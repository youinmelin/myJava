package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {

    @Autowired
    CmsPageRepository cmsPageRepository;

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
        CmsPage byPageNameAndSiteIdAndPageWebPath = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if (byPageNameAndSiteIdAndPageWebPath == null){
            cmsPage.setPageId(null);  // 数据库会自动创建pageId
            cmsPageRepository.save(cmsPage);
            CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.SUCCESS, cmsPage);
            return cmsPageResult;
        }else {
            // 如果有重复索引，则返回失败code
            CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.FAIL, null);
            return cmsPageResult;
        }

//        if (StringUtils.isNotEmpty(cmsPage.getSiteId())) {
//            cmsPage.setSiteId(cmsPage.getSiteId()); }
//        if (StringUtils.isNotEmpty(cmsPage.getPageAliase())) {
//            cmsPage.setSiteId(cmsPage.getPageAliase()); }
    }

}
