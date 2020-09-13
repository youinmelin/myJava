package lin.mapper;

import lin.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.List;

//import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserMapperTest {

    @Autowired
    private IUserMapper userMapper;

    @Test
    public void testSelectAllUser() {
//        List<User> users = userMapper.selectAll();
//        System.out.println(users);
        User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(user);
        User user1 = new User();
        user1.setName("youinme");
        user1.setAge(20);
        user1.setPassword("aaaaaa");
        user1.setUser_name("youinme");
        userMapper.insert(user1);
    }
}