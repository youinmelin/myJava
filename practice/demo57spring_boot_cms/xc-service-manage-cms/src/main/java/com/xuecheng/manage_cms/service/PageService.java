package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.Exception.CustomException;
import com.xuecheng.framework.Exception.ExceptionCast;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.*;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 18:32
 **/
@Service
public class PageService {

    @Autowired
    CmsPageRepository cmsPageRepository;


    /**
     * 页面查询,分页查询
     * @param page 页码，从1开始记数
     * @param size 每页记录数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findAllCmsPageByPage(int page, int size, QueryPageRequest queryPageRequest){
        page = page <= 0 ? page = 1 : page;
        size = size <= 0 ? size = 1 : size;
        Pageable pageable = PageRequest.of(page, size);
        if (queryPageRequest == null) {
            queryPageRequest = new QueryPageRequest();
        }

        CmsPage cmsPage = new CmsPage();
        if (StringUtils.isNotEmpty(queryPageRequest.getTemplateId())) {
            cmsPage.setPageAliase(queryPageRequest.getTemplateId()); }
        if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setPageAliase(queryPageRequest.getSiteId()); }
        if (StringUtils.isNotEmpty(queryPageRequest.getPageId())) {
            cmsPage.setPageAliase(queryPageRequest.getPageId()); }
        if (StringUtils.isNotEmpty(queryPageRequest.getPageName())) {
            cmsPage.setPageAliase(queryPageRequest.getPageName()); }

        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
//        exampleMatcher = exampleMatcher.withMatcher()

        Example<CmsPage> example = Example.of(cmsPage);
        Page<CmsPage> all = cmsPageRepository.findAll(example,pageable);
        long totalElements = all.getTotalElements();
        List<CmsPage> cmsPages = all.getContent();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(cmsPages);
        queryResult.setTotal(totalElements);
        ResultCode resultCode = CommonCode.SUCCESS;
        return new QueryResponseResult(resultCode, queryResult);
    }

    /**
     * 查询所有页面信息
     * @return
     */
    public QueryResponseResult findAllCmsPage() {
        List<CmsPage> cmsPages = cmsPageRepository.findAll();
        long total = cmsPages.size();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(cmsPages);
        queryResult.setTotal(total);
        ResultCode resultCode = CommonCode.SUCCESS;
        return new QueryResponseResult(resultCode, queryResult);
    }

    /**
     *
     * @param page
     * @param size
     * @param queryPageRequest
     * @return
     */
    public QueryResponseResult findCmsPageByExample(int page, int size, QueryPageRequest queryPageRequest) {
        page = page <= 0 ? 1 : page;
        size = size <= 0 ? 10 : size;
        page -= 1;
        Pageable pageable = PageRequest.of(page, size);

        if (queryPageRequest == null) {
           queryPageRequest = new QueryPageRequest();
        }
        CmsPage cmsPage = new CmsPage();
        if  (StringUtils.isNotEmpty(queryPageRequest.getTemplateId())){
            cmsPage.setTemplateId(queryPageRequest.getTemplateId()); }
        if  (StringUtils.isNotEmpty(queryPageRequest.getSiteId())){
            cmsPage.setSiteId(queryPageRequest.getSiteId()); }
        if  (StringUtils.isNotEmpty(queryPageRequest.getPageId())){
            cmsPage.setPageId(queryPageRequest.getPageId()); }
        if  (StringUtils.isNotEmpty(queryPageRequest.getPageName())){
            cmsPage.setPageName(queryPageRequest.getPageName()); }
        if  (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())){
            cmsPage.setPageAliase(queryPageRequest.getPageAliase()); }
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        // 设置模糊查询
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Page<CmsPage> pages = cmsPageRepository.findAll(example, pageable);
        List<CmsPage> cmspages = pages.getContent();
        long total = pages.getTotalElements();
        QueryResult queryResult = new QueryResult(cmspages, total);
        ResultCode resultCode = CommonCode.SUCCESS;
        QueryResponseResult queryResponseResult = new QueryResponseResult(resultCode, queryResult);
        return queryResponseResult;
    }

    /**
     * 新增页面
     * @param cmsPage
     * @return
     */
    public CmsPageResult addCmsPage(CmsPage cmsPage) {
        if (cmsPage == null) {
            // 抛出自定义异常
            ExceptionCast.cast(CommonCode.FAIL);
//            throw new CustomException(CommonCode.FAIL);
//            ResultCode resultCode = CommonCode.FAIL;
//            System.out.println("empty argument");
//            return new CmsPageResult(resultCode, null);
        }
        CmsPage cmsPage1 = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if (cmsPage1 != null) {
            // 页面数据已存在,抛出自定义异常
            ExceptionCast.cast(CommonCode.FAIL);
//            ResultCode resultCode = CommonCode.FAIL;
//            System.out.println("cmspage existed");
//            return new CmsPageResult(resultCode, null);
        }
        cmsPage.setPageId(null);
        cmsPageRepository.insert(cmsPage);
        ResultCode resultCode = CommonCode.SUCCESS;
        return new CmsPageResult(resultCode, cmsPage );
    }

    public CmsPageResult editCmsPage(String id, CmsPage cmsPage) {
        // 查id,如果存在就修改,不存在就返回错误码
        Optional<CmsPage> byId = cmsPageRepository.findById(id);
        CmsPage one = null;
        if (byId.isPresent()) {
            one = byId.get();
        }
        if (one == null) {
            ResultCode resultCode = CommonCode.FAIL;
            System.out.println("not found");
            return new CmsPageResult(resultCode, null);
        }
        one.setTemplateId(cmsPage.getTemplateId());
        one.setSiteId(cmsPage.getSiteId());
        one.setPageAliase(cmsPage.getPageAliase());
        one.setPageName(cmsPage.getPageName());
        one.setPageWebPath(cmsPage.getPageWebPath());
        one.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
        cmsPageRepository.save(one);
        return new CmsPageResult(CommonCode.SUCCESS,one);
    }

    public ResponseResult delCmsPage(String id) {
        Optional<CmsPage> byId = cmsPageRepository.findById(id);
        CmsPage cmsPage = null;
        if (byId.isPresent()) {
            cmsPage = byId.get();
            cmsPageRepository.deleteById(id);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        System.out.println("not existed");
        return new ResponseResult(CommonCode.FAIL);
    }

}
