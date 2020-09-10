package lin.domain;

import java.io.Serializable;

public class User implements Serializable {

    private Integer uid;
    private String username;
    private String departmentId;
    private Integer groupId;
    private String authority;

    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", groupId=" + groupId +
                ", authority='" + authority + '\'' +
                '}';
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
