package com.lin.controller;

import com.lin.pojo.User;
import com.lin.service.FreemarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequestMapping("/freemarker")
@Controller  // 不能用RestController,RestController输出的是json格式
public class FreemarkerController {
    @Autowired
    FreemarkerService freemarkerService;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/banner")
    public String bannerFreemarker(Map<String,Object> map) {
        String url = "http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f";
        // 使用RestTemplate请求数据
        Map body = restTemplate.getForEntity(url, Map.class).getBody();
        System.out.println(body);
        map.putAll(body);
        return "index_banner";
    }

    // 测试1
    @RequestMapping("/test1")
    public String test1(Map<String,Object> map) {
        // map形参里的数据可以传递给request域，并响应给用户，并传递给freemarker模板
        map.put("name", "lin");
        // 返回freemarker模板名称（不带后缀），位置基于resource/templates路径
        // 用户可以用localhost:8081/test1的方式访问
        return "freemarker_test1";
    }

    @RequestMapping("/allusers")
    public String queryAllUser(Map<String, Object> map) {
        List<User> users = freemarkerService.queryAllUsers();
        System.out.println(users);
        map.put("users",users);
        return "freemarker_test2";
    }

    @RequestMapping("/oneuser")
    public String queryOneUser(Map<String, Object> map) {
        List<User> users = freemarkerService.queryAllUsers();
        System.out.println(users);
        for (User user: users) {
            map.put("user", user);
        }
        return "freemarker_test3";
    }
}