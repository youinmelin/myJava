package lin.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Integer age;
    private String ingroup;
    private String tel;
    private List<Account> accounts;
    private List<Role> roles;

    public List<Role> getRoles() { return roles; }

    public void setRoles(List<Role> roles) { this.roles = roles; }

    public List<Account> getAccounts() { return accounts; }

    public void setAccounts(List<Account> accounts) { this.accounts = accounts; }

    public User() {
     }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ingroup='" + ingroup + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setIngroup(String ingroup) {
        this.ingroup = ingroup;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getIngroup() {
        return ingroup;
    }

    public String getTel() {
        return tel;
    }

    public User(Integer id, String name, Integer age, String ingroup, String tel) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.ingroup = ingroup;
        this.tel = tel;
    }
}
