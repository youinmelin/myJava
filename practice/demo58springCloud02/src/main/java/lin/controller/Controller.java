package lin.controller;

import lin.pojo.Student;
import lin.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class Controller {
    @Autowired
    StuService stuService;

    @GetMapping("/all")
    public String hello() {
        List<Student> students = stuService.selectAll();
        for (Student student: students ) {
            System.out.println(student);
        }
        return "<h2>select all</h2>";
    }
    @GetMapping("/one/{id}")
    public Student selectById(@PathVariable("id") Integer id) {
        return stuService.selectById(id);
    }

    @GetMapping("/stuclass/{sid}")
    public Student stuClassBySId(@PathVariable("sid") Integer sid) {
        System.out.println(sid);
        return stuService.selectStuWithClassBySId(sid);
    }

    @GetMapping("/stuclass")
    public List stuClassAll() {
        return stuService.selectAllStuWithClass();
    }

}
