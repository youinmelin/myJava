package lin.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {
    private String username;
    private String password;
    private Double money;
    private User user;

    private List<User> usersList;
    private Map<String,User> usersMap;

    public String getUsername() {
        return username;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                ", usersList=" + usersList +
                ", usersMap=" + usersMap +
                '}';
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    public void setUsersMap(Map<String, User> usersMap) {
        this.usersMap = usersMap;
    }

    public Account() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
