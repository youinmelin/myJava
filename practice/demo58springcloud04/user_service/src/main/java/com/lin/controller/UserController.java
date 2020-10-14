package com.lin.controller;

import com.lin.pojo.UserEntity;
import com.lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Value("${server.port}")
    String port;

    @GetMapping("/byid/{id}")
    public UserEntity findUserById(@PathVariable Long id) {
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserEntity userById = userService.findUserById(id);
        System.out.println(port);
        return userById;
    }
}
