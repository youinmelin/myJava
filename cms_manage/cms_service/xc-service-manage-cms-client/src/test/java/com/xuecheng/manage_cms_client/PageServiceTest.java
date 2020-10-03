package com.xuecheng.manage_cms_client;

import com.xuecheng.manage_cms_client.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {

    @Autowired
    PageService pageService;
    @Test
    public void testSavePageToServicePath() {
        String pageId = "5f74846775c01809c0246684";
        pageService.savePageToServicePath(pageId);
    }
}
