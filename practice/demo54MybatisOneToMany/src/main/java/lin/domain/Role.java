package lin.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private List<User> users;

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public Role() {

    }
}
