package lin.ui;

import lin.dao.IAccountDao;
import lin.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        //1. get core container object
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2. build Bean object by id
        IAccountService as = (IAccountService)ac.getBean("accountServiceImpl");

//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
        System.out.println(as);
//        System.out.println(adao);
        as.saveAccount();
        ac.close();
    }
}
