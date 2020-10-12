package com.lin.controller;

import com.lin.pojo.UserEntity;
import com.lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/byid/{id}")
    public UserEntity findUserById(@PathVariable Long id) {
        UserEntity userById = userService.findUserById(id);
        return userById;
    }
}
