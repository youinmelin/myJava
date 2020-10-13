package com.lin.controller;

import com.lin.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/byid/{id}")
    public UserEntity findById(@PathVariable Long id) {
        String url;
         url = "http://localhost:9091/user/byid/" + id;
        // 获取eureka中注册的user-service的实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user_service");
//        ServiceInstance serviceInstance = instances.get(0);
//         url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/byid/" + id;
        url = "http://userService/user/byid/" + id;
        UserEntity userEntity = restTemplate.getForObject(url, UserEntity.class);
        return userEntity;

    }
}
