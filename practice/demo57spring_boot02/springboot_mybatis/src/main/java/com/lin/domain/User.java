package com.lin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
//    @KeySql(useGenerateKeys = "true")
    private Integer id;
    private String username;
    private String password;
    private String name;
}
