package lin.test;

import lin.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUser {
    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IUserService userService = ac.getBean("userService", IUserService.class);
        userService.init();
        System.out.println(userService);
        userService.showAll();
    }
}
