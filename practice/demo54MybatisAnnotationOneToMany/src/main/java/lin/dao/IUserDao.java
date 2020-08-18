package lin.dao;

import lin.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAllUser();

    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

    @Select("select * from user where id = #{username}")
    User findUserById(Integer id);

    @Select("select * from user")
    @Results(id = "userAccountMapper", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "address", column = "address"),
            @Result(property = "accounts", column = "id",many = @Many(select="lin.dao.IAccountDao.findAccountByUid", fetchType = FetchType.LAZY))
    } )
    List<User> findAllUserWithAccount();
}
