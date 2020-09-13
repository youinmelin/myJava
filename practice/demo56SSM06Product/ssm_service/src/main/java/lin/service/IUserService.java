package lin.service;

import lin.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    UserInfo findUserByUsername(String username) throws Exception;

    UserInfo findUserWithRoleByUserId(Integer uid) throws Exception;

    UserInfo findUserWithRoleByUsername(String username) throws Exception;

    List<UserInfo> findAllUser();

    void insertUser(UserInfo userInfo) throws Exception;

    UserInfo findUserByUId(Integer uid);

    void addRoleToUser(Integer uId, Integer rId);
}
