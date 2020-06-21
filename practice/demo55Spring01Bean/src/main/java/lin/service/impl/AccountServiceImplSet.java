package lin.service.impl;

import lin.domain.Account;
import lin.service.IAccountService;

import java.util.Date;
import java.util.List;

public class AccountServiceImplSet implements IAccountService{
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AccountServiceImplSet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public void saveAccount() {
        System.out.println("method saveAccount has been implemented in service");
    }

    public List<Account> findAllAccount() {
        return null;
    }

    public Account findAccountById(Integer id) {
        return null;
    }

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }

    public void deleteAccount(Integer id) {

    }
}
