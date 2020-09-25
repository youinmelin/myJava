package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.*;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * 页面查询方法
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

    public QueryResponseResult findAllCmsPage() {
        List<CmsPage> cmsPages = cmsPageRepository.findAll();
        long total = cmsPages.size();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(cmsPages);
        queryResult.setTotal(total);
        ResultCode resultCode = CommonCode.SUCCESS;
        return new QueryResponseResult(resultCode, queryResult);
    }
}
