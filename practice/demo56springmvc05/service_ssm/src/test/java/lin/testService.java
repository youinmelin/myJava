package lin;

import lin.domain.Items;
import lin.service.IItemService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testService {

    @Test
    public void testFindItemById() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContextService.xml");
        IItemService itemService = ac.getBean(IItemService.class);
        Items item = itemService.findItemById(1);
        System.out.println(item);
    }
}
