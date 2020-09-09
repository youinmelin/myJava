package com.lin.service;

import com.lin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
public class UserService {

    // 根据id查询
    public User queryById(Integer id) {
        return new User();
    }
    // 新增用户
    @Transactional
    public void saveUser(){
        System.out.println("new user added");
    }
}

