package com.lin.controller;

import com.lin.domain.User;
import com.lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    @ResponseBody  // 返回的是字符串或json，所以要加上ResponseBody
    public List<User> queryAllUser() {
        List users = userService.findAllUser();
        return users;
    }
}
