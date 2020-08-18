package com.itheima.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private UserTest userTest;
    private Integer id;
    private Integer uid;
    private Double money;

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "user=" + userTest +
                ", id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }

    public void setUserTest(UserTest userTest) {
        this.userTest = userTest;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public UserTest getUserTest() {
        return userTest;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUid() {
        return uid;
    }

    public Double getMoney() {
        return money;
    }
}
