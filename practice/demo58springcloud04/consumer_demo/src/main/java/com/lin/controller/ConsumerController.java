package com.lin.controller;

import com.lin.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/byid/{id}")
    public UserEntity findById(Long id) {
        String url = "http://localhost:9091/user/byid/1";
        UserEntity userEntity = restTemplate.getForObject(url, UserEntity.class);
        return userEntity;

    }
}
