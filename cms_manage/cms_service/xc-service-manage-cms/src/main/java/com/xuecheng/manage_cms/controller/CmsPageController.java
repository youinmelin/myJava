package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi{

    @Autowired
    PageService pageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") Integer page, @PathVariable("size") Integer size, QueryPageRequest queryPageRequest) {
        // define QueryResult
//        QueryResult<CmsPage> queryResult = new QueryResult<>();
//        List<CmsPage> list = new ArrayList<>();
//        CmsPage cmsPage = new CmsPage();
//        cmsPage.setPageName("test page");
//        list.add(cmsPage);
//        queryResult.setList(list);
//        queryResult.setTotal(1);
//        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
//        return queryResponseResult;
        return pageService.findList(page, size,queryPageRequest);
    }

    @Override
    @GetMapping("/listExample/{page}/{size}")
    public QueryResponseResult findListByExample(@PathVariable("page") Integer page, @PathVariable("size") Integer size, QueryPageRequest queryPageRequest) {
        return pageService.findByExample(page, size, queryPageRequest);
    }

    @Override
    @GetMapping("/save/cmspage/")
    public void saveCmsPage(QueryPageRequest queryPageRequest) {
        pageService.savePage(queryPageRequest);

    }
}
