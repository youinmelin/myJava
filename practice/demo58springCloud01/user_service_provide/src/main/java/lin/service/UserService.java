package lin.service;

import lin.mapper.IUserMapper;
import lin.pojo.User;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@XSlf4j
@Service
public class UserService {

    @Autowired
    private IUserMapper userMapper;

    public User selectUserById(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        System.out.println("user: " + user);
//        log.debug("user");
        return user;
    }
}
