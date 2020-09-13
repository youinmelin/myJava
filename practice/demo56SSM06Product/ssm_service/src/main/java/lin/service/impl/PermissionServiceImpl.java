package lin.service.impl;

import lin.dao.IPermissionDao;
import lin.domain.Permission;
import lin.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    IPermissionDao permissionDao;

    @Override
    public List<Permission> findPermissionByRId(Integer rId) {
        List<Permission> permissions = permissionDao.findPermissionByRId(rId);
        return permissions;
    }

    @Override
    public List<Permission> findAllPermission() {
        List<Permission> permissionList = permissionDao.findAllPermission();
        return permissionList;
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }
}
