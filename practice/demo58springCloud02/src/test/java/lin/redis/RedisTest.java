package lin.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        // string
        redisTemplate.opsForValue().set("str1","lin"); // set value
        redisTemplate.boundValueOps("str2").set("lin2"); // set value
        System.out.println("str = " + redisTemplate.opsForValue().get("str"));
        System.out.println("str2 = " + redisTemplate.boundValueOps("str2").get());

        //hash
        redisTemplate.boundHashOps("h_key").put("name","lin");
        redisTemplate.boundHashOps("h_key").put("age","20");
        // get all domain
        Set keys_set = redisTemplate.boundHashOps("h_key").keys();
        System.out.println("hash 散列的所有域：" + keys_set);
        // get all value
        List keys_list = redisTemplate.boundHashOps("h_key").values();
        System.out.println("hash 散列的所有值：" + keys_list);

        //list
        redisTemplate.boundListOps("l_key").leftPush("c");
        redisTemplate.boundListOps("l_key").leftPush("b");
        redisTemplate.boundListOps("l_key").leftPush("a");
        keys_list = redisTemplate.boundListOps("l_key").range(0, -1);// get all
        System.out.println("list 列表中的所有元素：" + keys_list);

        // set
        redisTemplate.boundSetOps("s_key").add("a", "b", "c");
        keys_set = redisTemplate.boundSetOps("s_key").members();
        System.out.println("set 集合中所有的元素：" + keys_set);

        // sorted set
        redisTemplate.boundZSetOps("z_key").add("a", 30);
        redisTemplate.boundZSetOps("z_key").add("b", 10);
        redisTemplate.boundZSetOps("z_key").add("c", 20);
        keys_set = redisTemplate.boundZSetOps("z_key").range(0, -1);
        System.out.println("zset 有序集合中的所有元素：" + keys_set);
    }
}
