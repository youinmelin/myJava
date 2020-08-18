package com.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private String gender;
    private Date birthday;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + getAge() + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirth() {
        if (birthday != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(birthday);
        } else {
            return "";
        }
    }

    public int getAge() {
        int birth =  (int) this.birthday.getTime();
        int current = (int) System.currentTimeMillis();
        int currAge = (current - birth)/1000;
        return currAge;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User(String name, String gender, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }
}
