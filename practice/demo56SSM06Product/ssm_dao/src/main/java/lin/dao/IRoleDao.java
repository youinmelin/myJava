package lin.dao;

import lin.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {

    @Select("select * from role where rid = #{id}")
    List<Role> findRoleById(Integer id) ;

//    @Select("select * from role left join user_role ur on role.rid = ur.rid and ur.uid = #{uId}")
    // used by spring security, do not motify
    @Select("select * from role where rid in (select rid from user_role where uid = #{uId})")
    List<Role> findRolesByUId(Integer uId);

//    @Select("select * from role r left join role_permission rp on r.rid = rp.rid where r.rid in (select rid from user_role where uid = #{uId})")
    @Select("select * from role r where r.rid in (select rid from user_role where uid = #{uId})")
    @Results({
            @Result(id = true, column = "rid", property = "rId"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "rId", property = "permissions",
                    many = @Many( select = "lin.dao.IPermissionDao.findPermissionByRId")),
    })
    List<Role> findRoleWithPermissionByUId(Integer uId);

    @Select("select * from role")
    List<Role> findAllRoles();

    @Select("select * from role r left join role_permission rp on r.rid = rp.rid where r.rid = #{rId}")
    Role findRoleWithPermissionByRId(Integer rId);

    @Insert("insert into role (roleName, roleDesc) values(#{roleName}, #{roleDesc})")
    void saveRole(Role role);

    @Select("select * from role where rid not in (select rid from user_role where uid = #{uid})")
    List<Role> findRolesByUIdWhichNotHave(Integer uid);
}
