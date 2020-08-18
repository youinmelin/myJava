package com.lin.dao;

import com.lin.domain.User;

import java.util.List;

/**
 * 用户的持久层操作
 */
public interface IUserDao {
    List<User> findAll();
}
