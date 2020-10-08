package com.lin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate()  {
}
