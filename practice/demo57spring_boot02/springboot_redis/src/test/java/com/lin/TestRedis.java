package com.lin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.mapper.UserEntityMapper;
import com.lin.pojo.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserEntityMapper userEntityMapper;
    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    public void testRedisTemplate() throws JsonProcessingException {
        // BoundValueOperations: 操作redis的对象,封装了key对应的操作:set, get等等
        BoundValueOperations<String,Object> valueOps = redisTemplate.boundValueOps("keyname");
        Object o = valueOps.get();
        if (o == null) {
            // 如果redis中没有值,就从mysql中获取
            List<UserEntity> userEntities = userEntityMapper.selectAll();
            // 将List转为json
//            ObjectMapper objectMapper = new ObjectMapper();
//            String result = objectMapper.writeValueAsString(userEntities);
            System.out.println("get from mysql: " + userEntities);
            // 将获取的值存入redis
            valueOps.set(userEntities);
            o = valueOps.get();
        }else {
            System.out.println("get from redis:" + o);
        }
        System.out.println(o);
//        ValueOperations opsForValue = redisTemplate.opsForValue();
//        opsForValue.set("keyname", "value");
    }


    @Test
    public void testRedisString() {
        strRedisTemplate.opsForValue().set("name", "Nasa");
        System.out.println(strRedisTemplate.opsForValue().get("name"));
    }

    @Test
    public void testRedisSerializeable() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("Nasa");
        user.setUsersex("male");
        serializableRedisTemplate.opsForValue().set("User",user);
        UserEntity userGet = (UserEntity) serializableRedisTemplate.opsForValue().get("User");
        System.out.println(userGet);
    }
}
