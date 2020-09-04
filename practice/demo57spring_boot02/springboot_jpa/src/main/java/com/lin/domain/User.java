package com.lin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 声明主键生成策略（mysql用IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String name;

    public User() {
    }
}
