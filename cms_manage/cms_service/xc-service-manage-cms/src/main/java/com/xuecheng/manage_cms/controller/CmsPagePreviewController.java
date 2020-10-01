package com.xuecheng.manage_cms.controller;

import com.xuecheng.framework.web.BaseController;
import com.xuecheng.manage_cms.service.PageService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

/**
 * 静态化页面预览
 */
@Controller
public class CmsPagePreviewController extends BaseController{

    @Autowired
    PageService pageService;

    @RequestMapping(value = "/cms/preview/{pageId}", method = RequestMethod.GET)
    public void preview(@PathVariable("pageId") String pageId) throws IOException, TemplateException {
        // 执行静态化
        String htmlContent = pageService.getPageHtml(pageId);
        // 通过response(继承自BaseController)对象,将静态化页面字符串直接输出到浏览器
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(htmlContent.getBytes("utf-8"));
    }

}
