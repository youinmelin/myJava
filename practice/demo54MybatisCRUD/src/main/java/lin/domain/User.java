package lin.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String username;
    private String sex;
    private String brithday;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", brithday=" + brithday +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }


    public User() {
    }

    public User(Integer id, String username, String sex, String brithday) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.brithday = brithday;
    }
}
