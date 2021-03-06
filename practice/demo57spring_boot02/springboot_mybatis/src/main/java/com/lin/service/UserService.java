package com.lin.service;

import com.lin.domain.User;
import com.lin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List findAllUser() {
        return userMapper.selectAll();
    }
    public User queryUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
}
