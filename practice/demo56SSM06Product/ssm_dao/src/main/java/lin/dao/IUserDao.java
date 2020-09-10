package lin.dao;

import lin.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IUserDao {

    // used by spring security, do not motify
    @Select("select * from users where username = #{username}")
    @Results(
            value = {
                    @Result (id = true, column = "uid", property = "uid"),
                    @Result ( column = "email", property = "email"),
                    @Result ( column = "username", property = "username"),
                    @Result ( column = "phoneNum", property = "phoneNum"),
                    @Result ( column = "uid", property = "roles",
                            many = @Many(select = "lin.dao.IRoleDao.findRolesByUId", fetchType = FetchType.LAZY) )
            }
    )
    UserInfo findUserByUsername(String username) throws Exception;

    @Select("select * from users where uid = #{uId}")
    @Results(
        value = {
            @Result (id = true, column = "uid", property = "uid"),
                @Result ( column = "email", property = "email"),
                @Result ( column = "username", property = "username"),
                @Result ( column = "phoneNum", property = "phoneNum"),
                @Result ( column = "uid", property = "roles",
                many = @Many(select = "lin.dao.IRoleDao.findRoleWithPermissionByUId", fetchType = FetchType.LAZY) )
        }
    )
    UserInfo findUserWithRoleByUserId(Integer uId) throws Exception;

    @Select("select * from users")
    List<UserInfo> findAllUser();

    @Insert("insert into users (email,username,password,phoneNum,status) " +
            "values(#{email} ,#{username} ,#{password} ,#{phoneNum} ,#{status} )")
    void insertUser(UserInfo userInfo);

    @Select("select * from users where uid = #{uid}")
    UserInfo findUserByUId(Integer uid);

    @Insert("insert into user_role (uid, rid) values(#{uId}, #{rId})")
    void addRoleToUser(@Param("uId") Integer uId, @Param("rId") Integer rId);
}



