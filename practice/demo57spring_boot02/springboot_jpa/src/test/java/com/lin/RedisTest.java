package com.lin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.domain.User;
import com.lin.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SpringbootJpaApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest {

    // 0. 注入springBoot提供的redis模板,泛型：<key数据类型，value数据类型>
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRadis() throws JsonProcessingException {
        // 1. 从redis中获得数据 数据的形式：json字符串
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();
        // 2. 判断redis中是否存在数据
        if (null == userListJson) {
            //3. 如果不存在数据 从database查询
            List<User> users = userRepository.findAll();
            // 将查询出的数据存到redis，先将List集合转换成json格式,使用jackson进行转换
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(users);
            redisTemplate.boundValueOps("user.findall").set(userListJson);
            System.out.println("=====从MySql数据库获得user数据=====");
        }else {
            System.out.println("=====从redis缓存中获得user数据=====");
        }
        //4. 将返回的数据在控制台打印
        System.out.println("user:" + userListJson);
    }
}
