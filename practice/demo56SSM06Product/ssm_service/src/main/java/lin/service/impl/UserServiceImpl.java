package lin.service.impl;

import lin.dao.IUserDao;
import lin.domain.Role;
import lin.domain.UserInfo;
import lin.service.IUserService;
import lin.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findUserByUsername(username);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 处理自己的用户对象(UserInfo)封装成UserDetails,让spring security 获取username,password,用于认证登陆信息
//        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),
                 userInfo.getPassword(),
//                "{noop}" + userInfo.getPassword(),
                userInfo.getStatus() == 1 ? true : false,
                true,
                true,
                true,
                getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role: roles) {
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return list;
    }

    @Override
    public UserInfo findUserByUsername(String username) throws Exception {
        return null;
    }

    @Override
    public UserInfo findUserWithRoleByUserId(Integer uId) throws Exception {
        UserInfo userWithRole = userDao.findUserWithRoleByUserId(uId);
        return userWithRole;
    }

    @Override
    public UserInfo findUserWithRoleByUsername(String username) throws Exception {
        UserInfo userWithRole = userDao.findUserByUsername(username);
        return userWithRole;
    }

    @Override
    public List<UserInfo> findAllUser() {
        List<UserInfo> users = userDao.findAllUser();
        return users;
    }

    @Override
    public void insertUser(UserInfo userInfo) throws Exception{
        // 对密码进行加密
//        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfo.setPassword(BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassword()));
        userDao.insertUser(userInfo);
    }

    @Override
    public UserInfo findUserByUId(Integer uid) {
        UserInfo user = userDao.findUserByUId(uid);
        return user;
    }

    @Override
    public void addRoleToUser(Integer uId, Integer rId) {
        userDao.addRoleToUser(uId, rId);
    }

}
