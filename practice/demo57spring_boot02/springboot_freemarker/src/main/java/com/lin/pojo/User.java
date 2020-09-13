package com.lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "user")
public class User implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Date birthday;

    public User() {
    }

    public User(Integer id, String username, String password, String name, Date birthday) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
    }
}
