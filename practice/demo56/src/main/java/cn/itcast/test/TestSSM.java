package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestSSM {

    @Autowired
    private AccountService accountService;

    @Test
  public void testA() {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

}
