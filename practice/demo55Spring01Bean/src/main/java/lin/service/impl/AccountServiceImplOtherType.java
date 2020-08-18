package lin.service.impl;

import lin.domain.Account;
import lin.service.IAccountService;

import java.util.*;

public class AccountServiceImplOtherType implements IAccountService {
    private String[] strs;
    private List<String> mylist;
    private Set<String> myset;
    private Map<String, String> mymap;
    private Properties myprops;

    public void saveAccount() {
        System.out.println(Arrays.toString(strs));
        System.out.println(mylist);
        System.out.println(myset);
        System.out.println(mymap);
        System.out.println(myprops);
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

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

    public void setMyset(Set<String> myset) {
        this.myset = myset;
    }

    public void setMymap(Map<String, String> mymap) {
        this.mymap = mymap;
    }

    public void setMyprops(Properties myprops) {
        this.myprops = myprops;
    }

    public void setProps(Properties props) {
        this.myprops = props;
    }
}
