package com.lin.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "userentity")
public class UserEntity {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String username;
    private String usersex;

}
