package lin.service;

import lin.dao.IRoleDao;
import lin.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleService {

    Role findRoleDetailByRId();

    List<Role> findRolesByUId(Integer uId);

    Role findRoleWithPermissionByRId(Integer rId);

    List<Role> findRoleWithPermissionByUId(Integer uId);

    List<Role> findAllRoles();

    void saveRole(Role role);

    List<Role> findRolesByUIdWhichNotHave(Integer uid);
}
