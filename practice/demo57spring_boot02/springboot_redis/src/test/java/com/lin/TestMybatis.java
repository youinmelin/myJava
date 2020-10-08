package com.lin;

import com.lin.mapper.UserEntityMapper;
import com.lin.pojo.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMybatis {
    @Autowired
    UserEntityMapper userEntityMapper;

    @Test
    public void testMapper() {
        List<UserEntity> userEntities = userEntityMapper.selectAll();
        System.out.println(userEntities);
    }
}
