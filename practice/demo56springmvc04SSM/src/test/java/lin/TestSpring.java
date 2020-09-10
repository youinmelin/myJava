package lin;

import lin.domain.Account;
import lin.domain.FilenameAndMsg;
import lin.service.IAccountService;
import lin.service.IFileMsgService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TestSpring {


    ApplicationContext ac;
    IAccountService accountService;
    IFileMsgService fileMsgService;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        accountService = ac.getBean("accountService", IAccountService.class);
        fileMsgService = ac.getBean("fileMsgService", IFileMsgService.class);
    }

    @Test
    public void testRun1() {
        List<Account> accounts = accountService.findAllAccount();
        for (Account account :
                accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testSaveFileMsg() {
        FilenameAndMsg fileMsg = new FilenameAndMsg(null,1, "test2", "index.jsp", 50, new Date());
        fileMsgService.saveFileMsg(fileMsg);
    }
    @Test
    public void testFindAllFileMsg() {
        Integer currentPage = 3;
        Integer count = 99;
        Integer numPerPage = 5;
        Integer currentFirstIndex = (currentPage-1)*numPerPage;
        List<FilenameAndMsg> allFileMsg = fileMsgService.findAllFileMsg(currentFirstIndex, numPerPage);
        for (FilenameAndMsg fm :
                allFileMsg) {
            System.out.println(fm);
        }
    }

    //one to one
    @Test
    public void testFindMsgWithUser() {
        Integer currentPage = 1;
        Integer count = 99;
        Integer numPerPage = 3;
        Integer currentFirstIndex = (currentPage-1)*numPerPage;
        List<FilenameAndMsg> msgList = fileMsgService.findMsgWithUser(currentFirstIndex, numPerPage);
        for (FilenameAndMsg fm :
                msgList) {
            System.out.println(fm);
            System.out.println(fm.getUser());
        }
    }

    @Test
    public void testDelFileByMsgId() {
        String filename = fileMsgService.delFileByMsgId(81);
        System.out.println(filename);
    }

    @Test
    public void testMsgCount() {
        System.out.println(fileMsgService.findMsgCount());
    }
}
