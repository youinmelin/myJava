package com.lin.service;

import com.lin.domain.Teachplan;
import com.lin.mapper.TeachplanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachplanService {
    @Autowired
    TeachplanMapper teachplanMapper;

    public List<Teachplan> findTeachPlanById(String courseId){
        List<Teachplan> teachplans = teachplanMapper.findByCourseId(courseId);
        return teachplans;
    }
}
