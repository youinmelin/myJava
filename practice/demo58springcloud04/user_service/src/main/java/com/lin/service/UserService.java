package com.lin.service;


import com.lin.mapper.UserMapper;
import com.lin.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public UserEntity findUserById(Long id) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(id);
        return userEntity;
    }
}
