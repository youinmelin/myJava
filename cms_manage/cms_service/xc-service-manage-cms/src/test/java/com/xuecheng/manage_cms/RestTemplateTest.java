package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testRestTemplate() {
        String url = "http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f";
        // 从url获取数据,保存成map类型
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(url, Map.class);
        Map body = forEntity.getBody();
        System.out.println(body);
    }
}
