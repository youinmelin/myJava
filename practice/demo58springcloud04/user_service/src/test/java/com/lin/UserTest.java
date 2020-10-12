package com.lin;

import com.lin.pojo.UserEntity;
import com.lin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {
    @Autowired
    UserService userService;

    @Test
    public void testFindById() {
        UserEntity userById = userService.findUserById(1l);
        System.out.println(userById);
    }
}
