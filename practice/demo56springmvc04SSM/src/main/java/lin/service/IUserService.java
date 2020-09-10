package lin.service;

import lin.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserService {

    List<User> findAllUser();

    String findUsernameById(Integer uid);

    User findUserById(Integer uid);
}
