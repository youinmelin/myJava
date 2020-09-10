package lin.service.impl;

import lin.dao.IRoleDao;
import lin.dao.IUserDao;
import lin.domain.Role;
import lin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    IRoleDao roleDao;

    @Override
    public Role findRoleDetailByRId() {
        return null;
    }

    @Override
    public List<Role> findRolesByUId(Integer uId) {
        List<Role> roles = roleDao.findRolesByUId( uId);
        return roles;
    }

    @Override
    public Role findRoleWithPermissionByRId(Integer uId) {
        return null;
    }

    @Override
    public List<Role> findRoleWithPermissionByUId(Integer uId) {
        List<Role> roles = roleDao.findRoleWithPermissionByUId(uId);
        return roles;
    }

    @Override
    public List<Role> findAllRoles() {
        List<Role> roles = roleDao.findAllRoles();
        return roles;
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public List<Role>  findRolesByUIdWhichNotHave(Integer uid) {
        List<Role> roles = roleDao.findRolesByUIdWhichNotHave(uid);
        return roles;
    }
}
