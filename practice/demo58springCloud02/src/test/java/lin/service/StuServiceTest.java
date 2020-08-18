package lin.service;

import lin.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuServiceTest {
    @Autowired
    private StuService stuService;
    @Test
    public void selectById() throws Exception {
        Student student = stuService.selectById(2);
        System.out.println(student);
    }

}