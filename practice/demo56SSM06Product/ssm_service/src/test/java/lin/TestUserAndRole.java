package lin;

import lin.dao.IPermissionDao;
import lin.domain.Permission;
import lin.domain.Role;
import lin.domain.UserInfo;
import lin.service.IPermissionService;
import lin.service.IRoleService;
import lin.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class TestUserAndRole {

    IUserService userService;
    IRoleService roleService;
    IPermissionService permissionService;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContextService.xml");
        userService = ac.getBean(IUserService.class);
        roleService = ac.getBean(IRoleService.class);
        permissionService = ac.getBean(IPermissionService.class);
    }

    @Test
    public void testUsernamePassword() {
        UserDetails user = userService.loadUserByUsername("ygqs");
        System.out.println(user);
    }

    @Test
    public void testFindUserRoleByUId() throws Exception {
        UserInfo userWithRoleByUserId = userService.findUserWithRoleByUserId(2);
        System.out.println(userWithRoleByUserId);
        List<Role> roles = userWithRoleByUserId.getRoles();
//        System.out.println(roles);
        for ( Role role: roles ){
            System.out.println("---------------");
            System.out.println(role);
            System.out.println(role.getPermissions());
        }
    }

    @Test
    public void testFindUserRoleByUName() throws Exception {
        UserInfo userWithRoleByUName = userService.findUserWithRoleByUsername("ygqs");
        System.out.println(userWithRoleByUName);
        System.out.println(userWithRoleByUName.getRoles());
    }

    @Test
    public void testFindAllUser() {
        List<UserInfo> allUser = userService.findAllUser();
        for (UserInfo u : allUser) {
            System.out.println(u);
        } }

    @Test
    public void testFindRolePermissionByUId() {
        List<Role> roles = roleService.findRoleWithPermissionByUId(2);
        for (Role role :
                roles) {
            System.out.println(role);
            System.out.println(role.getPermissions());
        }
    }

    @Test
    public void testFindPermissionByRId() {
        List<Permission> permissions = permissionService.findPermissionByRId(2);
        System.out.println(permissions);
    }

    @Test
    public void testInsertUser() throws Exception {
        UserInfo userInfo = new UserInfo("good", "goog@gmail.com", "aaaaaa", "1111111", 1);
        userService.insertUser(userInfo);
    }
}
