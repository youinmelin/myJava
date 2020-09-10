package lin;

import lin.dao.ITravellerDao;
import lin.domain.Order;
import lin.domain.Traveller;
import lin.service.IOrderService;
import lin.service.ITravellerService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestOrder {

    ApplicationContext ac;
    IOrderService orderService;
    ITravellerService travellerService;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("classpath:applicationContextService.xml");
        orderService = ac.getBean(IOrderService.class);
        travellerService = ac.getBean(ITravellerService.class);
    }

    @Test
    public void testFindAllOrder() {
        List<Order> orders = orderService.findAllOrder();
        for (Order order :
                orders) {
            System.out.println(order);
        }
    }

    @Test
    public void testFindOrderWithProduct() {
        List<Order> orders = orderService.findOrderWithProduct();
        for (Order order :
                orders) {
            System.out.println(order);
            System.out.println(order.getProduct());
        }
    }

    @Test
    public void testFindOrderWithMemberByOId() {
        Order order = orderService.findOrderWithMemberProductByOId(3);
        System.out.println(order);
        System.out.println(order.getMember());
        System.out.println(order.getProduct());
        System.out.println(order.getTravellers());
    }

    @Test
    public void testFindTravellsByOrderId() {
        List<Traveller> travellers = travellerService.findTravellersByOrderId(4);
        for (Traveller t :
                travellers) {
            System.out.println(t);
        }
    }
}
