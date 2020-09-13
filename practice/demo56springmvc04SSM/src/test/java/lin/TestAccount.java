package lin;

import lin.domain.Account;
import lin.domain.FilenameAndMsg;
import lin.service.IAccountService;
import lin.service.IFileMsgService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestAccount {


    ApplicationContext ac;
    IAccountService accountService;
    IFileMsgService fileMsgService;
    @Before
    public void init(){
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = ac.getBean(IAccountService.class);
        fileMsgService = ac.getBean(IFileMsgService.class);

    }
    @Test
    public void testFindAllAccount() {
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            String dateStr = null;
            if (account.getDate() != null) {
                // turn Date to String
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dateStr = dateFormat.format(account.getDate());
            }
            System.out.println(account + dateStr);
        }
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("test1");
        account.setMoney(5000d);
        account.setDate(new Date());
        accountService.saveAccount(account);
    }

    @Test
    public void testFindAllMsg() {
//        FilenameAndMsg msg = new FilenameAndMsg(null, 1, "abc", "index.html", 0, null);
        List<FilenameAndMsg> msgs = fileMsgService.findAllFileMsg(0, 5);
        for (FilenameAndMsg msg : msgs) {
            String dateStr = null;
            if (msg.getDatetime() != null){
                // turn Date to String
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dateStr = dateFormat.format(msg.getDatetime());
            }
            System.out.println(msg + dateStr);
        }
    }

    @Test
    public void math(){
        int a = 10;
        int b = 3;
        int c = a/b;
        if (a%b>0){
           c++;
        }
        System.out.println(a/b);
        System.out.println(c);
    }
}
