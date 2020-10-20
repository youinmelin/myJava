package com.lin.test;

import com.lin.pojo.Students;
import com.lin.service.StudentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService {

    @Autowired
    StudentsService studentsService;
    @Test
    public void testStudent() {
        List<Students> students = studentsService.queryAllStudents();
        System.out.println(students);


    }
}
