package com.lin.service;

import com.lin.mapper.FreemarkerMapper;
import com.lin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreemarkerService {
    @Autowired
    FreemarkerMapper freemarkerMapper;

    public List<User> queryAllUsers() {
        return freemarkerMapper.selectAll();
    }
}
