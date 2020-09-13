package lin.controller;

import lin.mapper.IUserMapper;
import lin.pojo.User;
import lin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@Slf4j
//@Controller
@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
//    private DataSource dataSource;
    private UserService userService;

//    @RequestMapping()
//    @ResponseBody
    @GetMapping("{id}")
    public User hello(@PathVariable("id") Long id) {
//        System.out.println("hello method is running.");
//        System.out.println(dataSource);
        log.debug("hello method is running");
//        return "hello,spring boot!";
        return userService.selectUserById(id);
    }
}
