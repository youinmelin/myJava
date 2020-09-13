package lin.service.impl;

import lin.domain.User;
import lin.dao.IUserDao;
import lin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userdao;

    @Override
    public List<User> findAllUser() {

        return userdao.findAllUser();

    }

    @Override
    public String findUsernameById(Integer uid) {

        return userdao.findUsernameById(uid);
    }

    @Override
    public User findUserById(Integer uid) {
        return null;
    }

//    @Override
//    public List<User> findMsgWithUser() {
//        List<User> list = userdao.findMsgWithUser();
//        return list;
//    }
}
