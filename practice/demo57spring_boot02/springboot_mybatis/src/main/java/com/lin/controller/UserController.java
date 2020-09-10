package com.lin.controller;

import com.lin.domain.User;
import com.lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public List<User> queryAllUser() {
        List users = userService.findAllUser();
        System.out.println("a new request");
        return users;
    }


    @GetMapping("/userid")
    public User queryUserByUserId(@RequestParam("id") Integer id) {
        System.out.println("id:" + id);
        User user = userService.queryUserById(id);
        return user;
    }
    @GetMapping("/userid/{id}")
    public User queryUserByUserId2(@PathVariable("id") Integer id) {
        System.out.println("id:" + id);
        User user = userService.queryUserById(id);
        return user;
    }
}
