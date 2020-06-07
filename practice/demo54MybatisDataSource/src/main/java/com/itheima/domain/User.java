package com.itheima.domain;

import java.io.Serializable;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class User implements Serializable {

    private Integer userId;
    private String userName;
    private String userSex;
    private String userBrithday;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBrithday() {
        return userBrithday;
    }

    public void setUserBrithday(String userBrithday) {
        this.userBrithday = userBrithday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBrithday=" + userBrithday +
                '}';
    }
}
