package lin.dao;

import lin.domain.User;
import lin.domain.queryVo;

import java.util.List;

public interface IUserDao {
    public List<User> findAll();

    public List<User> findByUser(User user);

    public List<User> findByVo(queryVo vo);

    // one to mutiple
    public List<User> findAllUserAccount();

    public List<User> findAllUserRole();
}

