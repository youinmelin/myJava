package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.model.response.QueryResponseResult;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsPageServiceTest {

    @Autowired
    PageService pageService;
    @Test
    public void testGetPageHtml() throws IOException, TemplateException {
        String pageHtml = pageService.getPageHtml("5f74846775c01809c0246684");
        System.out.println(pageHtml);

    }
}
