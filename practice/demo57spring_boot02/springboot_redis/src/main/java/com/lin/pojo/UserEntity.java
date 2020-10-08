package com.lin.pojo;

import org.springframework.data.annotation.Id;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "userentity")
public class UserEntity implements Serializable{
    private static final long serialVersionUID = 5237730257103305078L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String username;
    private String usersex;

    public UserEntity() {
    }


    public UserEntity(long l, String lin, String male) {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                '}';
    }

    public Long getId() {
        return null;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsersex() {
        return usersex;
    }
    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }
}
