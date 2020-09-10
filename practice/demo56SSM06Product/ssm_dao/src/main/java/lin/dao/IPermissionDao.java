package lin.dao;

import lin.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermissionDao {

    @Select("select * from permission")
    List<Permission> findAllPermission();

    @Select("select * from permission where pid = #{pId}")
    List<Permission> findPermissionByPId(Integer pId);

    @Select("select * from permission p left join role_permission rp on p.pid = rp.pid where rId = #{rId}")
    List<Permission> findPermissionByRId(Integer rId);

    @Insert("insert into permission (permissionName, url) values(#{permissionName}, #{url})")
    void savePermission(Permission permission);

}
