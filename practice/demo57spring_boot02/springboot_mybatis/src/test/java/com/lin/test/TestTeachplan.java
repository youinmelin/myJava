package com.lin.test;

import com.lin.domain.Teachplan;
import com.lin.service.TeachplanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTeachplan {

    @Autowired
    TeachplanService teachplanService;

    @Test
    public void testFindTeachplanById() {
        String courseId = "4028e581617f945f01617f9dabc40000";
        List<Teachplan> teachplans = teachplanService.findTeachPlanById(courseId);
        System.out.println(teachplans);
    }
}
