package lin.controller;

import lin.pojo.Student;
import lin.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class StuController {
    @Autowired
    StuService stuService;

    @GetMapping("/all")
    public List<Student> selectAllStu() {
        System.out.println("USL: all");
        return stuService.selectAllStu();
    }
}
