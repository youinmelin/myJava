package com.lin.controller;

import com.lin.pojo.UserEntity;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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
@DefaultProperties(defaultFallback = "findByIdDefaultFallback") // 开启线程隔离和失败处理 用于整个类
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/byid/{id}")
//    @HystrixCommand(fallbackMethod = "findByIdFallback")  // 开启线程隔离和失败处理 用于单个方法
    @HystrixCommand()
//    @HystrixCommand(commandProperties = {
//            // 设置超时时长2000ms
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000")
//    })  // 开启类上的@DefaultProperties注解,就使用默认失败函数
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

    /**
     * 失败处理函数 必须和原函数返回值,参数列表一致
     */
    public UserEntity findByIdFallback(@PathVariable Long id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("system busy");
        return userEntity;
    }

    /**
     * 通用的fallback函数, 参数为空
     */
    public UserEntity findByIdDefaultFallback() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("system busy default");
        return userEntity;
    }
}
