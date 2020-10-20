package com.lin.service;

import com.lin.mapper.StuMapper;
import com.lin.pojo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    StuMapper stuMapper;

    public List<Students> queryAllStudents() {
        return stuMapper.selectAll();
    }
}
