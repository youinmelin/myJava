package lin.dao;

import lin.domain.FilenameAndMsg;
import lin.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("select * from user order by username ")
    List<User> findAllUser();

    @Select("select username from user where uid = #{uid}")
    String findUsernameById(Integer uid);

    @Select("select * from user where uid = #{uid}")
    User findUserById(Integer uid);

}
