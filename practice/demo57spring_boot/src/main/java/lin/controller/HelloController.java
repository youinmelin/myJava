package lin.controller;

import lin.pojo.Student;
import lin.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/hello")
public class HelloController {

//    @Autowired
//    private DataSource dataSource;
    @Autowired
    StuService stuService;

    @GetMapping("/one/{sid}")
    public Student queryBySId(@PathVariable("sid") Integer sid) {

        return stuService.queryBySId(sid);
    }
}
