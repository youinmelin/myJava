package com.lin;

import com.lin.pojo.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisYiHuTeacher {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedisTemplate() {
        /*
        opsForValue() 操作字符串
        opsForList()
        opsForHash()
        opsForSet()
        opsForZset()
         */
        stringRedisTemplate.opsForHash().put("phone","brand","mi");
        stringRedisTemplate.opsForHash().put("phone","founder","leijun");
        BoundValueOperations workplace = stringRedisTemplate.boundValueOps("workplace");
        workplace.set("shahe");
        stringRedisTemplate.opsForValue().set("User", new UserEntity(2L,"Nasa","male").toString());
        stringRedisTemplate.opsForList().leftPush("PC","ASUS");
        stringRedisTemplate.opsForList().leftPush("PC","lenove");
        stringRedisTemplate.opsForList().rightPush("PC","NVida");
        List<String> pcList = stringRedisTemplate.opsForList().range("PC", 0L, 1L);
        System.out.println(pcList);

    }
}
