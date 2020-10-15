package com.xuecheng.manage_course.dao;

import com.netflix.discovery.converters.Auto;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_course.feignClient.CmsPageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFeignClient {

//    @Autowired
//    RestTemplate restTemplate;
    @Autowired
    CmsPageClient cmsPageClient;  // 由自定义的feign接口生成的代理对象,

    @Test
    public void testFeignClient() {
        CmsPage cmsPageById = cmsPageClient.findCmsPageById("5a754adf6abb500ad05688d9");
        System.out.println(cmsPageById);

    }
}
