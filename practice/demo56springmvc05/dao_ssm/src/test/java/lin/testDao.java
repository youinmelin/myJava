package lin;

import lin.dao.IItemsDao;
import lin.domain.Items;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDao {

    @Test
    public void testFindItemById() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContextDao.xml");
        IItemsDao itemsDao = ac.getBean(IItemsDao.class);
        Items item = itemsDao.findItemById(1);
        System.out.println(item);
    }
}
