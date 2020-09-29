package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 17:24
 **/
@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    PageService pageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findAllCmsPageByPage(@PathVariable("page") int page, @PathVariable("size")int size, QueryPageRequest queryPageRequest) {
        return pageService.findAllCmsPageByPage(page, size, queryPageRequest);
    }

    @Override
    @GetMapping("/listExample/{page}/{size}")
    public QueryResponseResult findCmsPageByExample(@PathVariable("page") int page,@PathVariable("size") int size, QueryPageRequest queryPageRequest) {
        return pageService.findCmsPageByExample(page, size, queryPageRequest);
    }

    @Override
    @GetMapping("/list/all")
    public QueryResponseResult findAllCmsPage() {
        return pageService.findAllCmsPage();
    }

    @Override
    @PostMapping("/add")
    public CmsPageResult addCmsPage(@RequestBody CmsPage cmsPage) {
        return pageService.addCmsPage(cmsPage);
    }

    @Override
    @PutMapping("/edit/{id}")
    public CmsPageResult editCmsPage(@PathVariable("id") String id, @RequestBody CmsPage cmsPage) {
        return pageService.editCmsPage(id, cmsPage);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult delCmsPage(@PathVariable String id) {
        return pageService.delCmsPage(id);
    }
}
