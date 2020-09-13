package lin.controller;

import lin.pojo.User;
import lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")  //port:8081
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User selectUserById(@PathVariable("id") Long id) {
        return userService.selectUserById(id);
    }
}
