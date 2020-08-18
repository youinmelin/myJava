package lin;

import lin.mapper.StuMapper;
import lin.pojo.Student;
import lin.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestStu {
    @Autowired
    StuService stuService;
    StuMapper stuMapper;
    @Test
    public void testStu(){
        Student stu = new Student(3, "zheng", 007, "male", 2, null );
        System.out.println(stu);
        Student student = stuService.selectStuWithClassBySId(1);
        System.out.println(student);
    }
}
