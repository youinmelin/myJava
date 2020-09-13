package lin.service;

import lin.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findPermissionByRId(Integer rId);

    List<Permission> findAllPermission();

    void savePermission(Permission permission);
}
