package com.lin.service;

import com.lin.mapper.ClassMaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    ClassMaper classMaper;

    public List<Class> queryAllClass() {
        return classMaper.selectAll();
    }
}
