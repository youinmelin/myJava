package com.xuecheng.manage_cms.service;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.config.RabbitmqConfig;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class PageService {

    @Autowired
    CmsPageRepository cmsPageRepository;
    @Autowired
    CmsSiteRepository cmsSiteRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CmsConfigService cmsConfigService;
    @Autowired
    CmsTemplateService cmsTemplateService;
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket gridFSBucket;
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 页面查询方法
     * @param page 页码，从1开始
     * @param size 每页的数据条数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList( Integer page, Integer size, QueryPageRequest queryPageRequest) {

        page = page<=0 ? page = 1 : page; // 调整以后，让第一页是从一开始
        size = size<=0 ? size = 10 : size; // 默认让size = 10
        page = page - 1;
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());  // 数据列表
        queryResult.setTotal(all.getTotalElements()); // 数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    public QueryResponseResult findByExample(Integer page, Integer size, QueryPageRequest queryPageRequest) {
        page = page<=0 ? page = 1 : page; // 调整以后，让第一页是从一开始
        size = size<=0 ? size = 10 : size; // 默认让size = 10
        page -= 1;
        if (queryPageRequest == null) {
            queryPageRequest = new QueryPageRequest();
        }
        // set pageable
        Pageable pageable = PageRequest.of(page, size);
        // set exampleMatcher
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());

        CmsPage cmsPage = new CmsPage();
//        cmsPage.setPageWebPath("/course/");
        // set 查询条件  通过queryPageRequest获取输入值
        if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
            System.out.println("set siteId");
            cmsPage.setSiteId(queryPageRequest.getSiteId()); }
        if (StringUtils.isNotEmpty(queryPageRequest.getTemplateId())) {
            System.out.println("set templateId");
            cmsPage.setTemplateId(queryPageRequest.getTemplateId()); }
        if (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())) {
            System.out.println("set pageAliase");
            cmsPage.setPageAliase(queryPageRequest.getPageAliase()); }
        System.out.println(cmsPage);

        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Page<CmsPage> cmsPages = cmsPageRepository.findAll(example, pageable);
        QueryResult<CmsPage> queryResult = new QueryResult<>();
        queryResult.setList(cmsPages.getContent());
        queryResult.setTotal(cmsPages.getTotalElements());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 新增页面数据
     * @param cmsPage 数据对象
     * @return cmsPageResult 是一个包含数据对象和操作结果信息的对象
     */
    public CmsPageResult addCmsPage( CmsPage cmsPage) {
        //校验页面是否存在，根据页面名称、站点Id、页面webpath查询
        if (cmsPage == null) {
            // 抛出非法参数异常

        }
        CmsPage byPageNameAndSiteIdAndPageWebPath = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if(byPageNameAndSiteIdAndPageWebPath != null) {
            // 页面已经存在 抛出异常:页面已经存在
            System.out.println("页面已经存在");
            ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);

        }
        cmsPage.setPageId(null);  // 数据库会自动创建pageId
        cmsPageRepository.save(cmsPage);
        CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.SUCCESS, cmsPage);
        return cmsPageResult;
    }
//    public CmsPageResult addCmsPage( CmsPage cmsPage) {
//        //校验页面是否存在，根据页面名称、站点Id、页面webpath查询
//        CmsPage byPageNameAndSiteIdAndPageWebPath = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
//        if (byPageNameAndSiteIdAndPageWebPath == null){
//            cmsPage.setPageId(null);  // 数据库会自动创建pageId
//            cmsPageRepository.save(cmsPage);
//            CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.SUCCESS, cmsPage);
//            return cmsPageResult;
//        }else {
//            // 如果有重复索引，就不能新增，返回失败code
//            CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.FAIL, null);
//            return cmsPageResult;
//        }
//    }

    // find cmsPage by id
    public CmsPage findCmsPageByID(String id) {
        Optional<CmsPage> cmsPageOptional = cmsPageRepository.findById(id);
        if (cmsPageOptional.isPresent()){
            return cmsPageOptional.get();
        }
        return null;
    }

    // modify page data
    public CmsPageResult modifyCmsPage(String id, CmsPage cmsPage) {
        // 根据id从数据库查询页面信息
        CmsPage cmsPageByID = this.findCmsPageByID(id);
        if (cmsPageByID != null) {
            //更新模板id
            cmsPageByID.setTemplateId(cmsPage.getTemplateId());
            //更新所属站点
            cmsPageByID.setSiteId(cmsPage.getSiteId());
            //更新页面别名
            cmsPageByID.setPageAliase(cmsPage.getPageAliase());
            //更新页面名称
            cmsPageByID.setPageName(cmsPage.getPageName());
            //更新访问路径
            cmsPageByID.setPageWebPath(cmsPage.getPageWebPath());
            //更新物理路径
            cmsPageByID.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
            //更新DataUrl
            cmsPageByID.setDataUrl(cmsPage.getDataUrl());
            // 提交修改
            cmsPageRepository.save(cmsPageByID);
            return new CmsPageResult(CommonCode.SUCCESS, cmsPageByID);
        }
        return new CmsPageResult(CommonCode.FAIL, null);
    }

    // 根据ID删除页面
    public ResponseResult delCmsPage(String id) {
        // 先查询一下
        Optional<CmsPage> cmsPageOptional = cmsPageRepository.findById(id);
        if (cmsPageOptional.isPresent()){
            cmsPageRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS );
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    // 页面静态化
    public String getPageHtml(String pageId) throws IOException, TemplateException {
        // get DataUrl by cmspageId
//        CmsPage cmsPageByID = this.findCmsPageByID("5f74846775c01809c0246684");
        CmsPage cmsPageByID = this.findCmsPageByID(pageId);
        if (cmsPageByID == null) {
            // cannot find cmspage
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
        String dataUrl = cmsPageByID.getDataUrl();
        String templateId = cmsPageByID.getTemplateId();
        String pagePhysicalPath = cmsPageByID.getPagePhysicalPath();
        String htmlFileId = cmsPageByID.getHtmlFileId();
        if (StringUtils.isEmpty(dataUrl)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_DATAURLISNULL);
        }
        if (StringUtils.isEmpty(templateId)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        if (StringUtils.isEmpty(pagePhysicalPath) || StringUtils.isEmpty(htmlFileId)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_FILENAMEISNULL);
        }
        // get data model by DataUrl
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        Map model = forEntity.getBody();
        if (model == null) {
            // 数据模型获取不到
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_DATAISNULL);
        }
        System.out.println(model);
        // get file_id
        String fileId = cmsTemplateService.queryCmsTemplateById(templateId).getTemplateFileId();
        System.out.println("fileId: " + fileId);
        // get template content
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        String content = IOUtils.toString(gridFsResource.getInputStream(), "utf-8");
        if (StringUtils.isEmpty(content)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        System.out.println("template file content: " + content);
        // template content string to template
        Configuration configuration = new Configuration(Configuration.getVersion());
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("template", content);
        configuration.setTemplateLoader(stringTemplateLoader);
        Template template = configuration.getTemplate("template", "utf-8");
        // staticize
        String staticContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        return staticContent;
    }

    // 页面发布
    public ResponseResult post(String pageId) {
        CmsPage cmsPage = this.findCmsPageByID(pageId);
        if (cmsPage == null) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOTEXISTS);
        }
        // 1.1执行静态化
        String staticContent = null;
        try {
            staticContent = this.getPageHtml(pageId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        // 1.2将静态化文件存储到GridFS中
        InputStream inputStream = null;
        try {
            inputStream = IOUtils.toInputStream(staticContent, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectId objectId = gridFsTemplate.store(inputStream, cmsPage.getPageName());
        // 1.3将html文件id更新到cmsPage中
        cmsPage.setHtmlFileId(objectId.toHexString());
        CmsPage cmsPage1 = cmsPageRepository.save(cmsPage);

        // 2.向MQ发消息
        // 2.1 创建消息对象
        Map<String, String> msg = new HashMap<>();
        msg.put("pageId", cmsPage1.getPageId());
        String jsonString = JSON.toJSONString(msg);
        // 2.2 发送给MQ
        String exRoutingCmsPostpage = RabbitmqConfig.EX_ROUTING_CMS_POSTPAGE; // 交换机
        String routingKey = cmsPage1.getSiteId(); // routingKey
        rabbitTemplate.convertAndSend(exRoutingCmsPostpage, routingKey, jsonString);
        return new ResponseResult(CommonCode.SUCCESS);
    }

}
