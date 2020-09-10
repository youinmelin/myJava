package lin.service;

import lin.mapper.IUserMapper;
import lin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private IUserMapper userMapper;

    public User selectUserById(Long uId) {
        User user = userMapper.selectByPrimaryKey(uId);
        return user;
    }

    @Transactional
    public void insertUser(User user) {
        userMapper.insert(user);
    }
}
