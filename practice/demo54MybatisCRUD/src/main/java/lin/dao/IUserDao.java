package lin.dao;

import lin.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void delUser(Integer id);

    User findById(Integer id);

    List<User> findByName(String name);
}
