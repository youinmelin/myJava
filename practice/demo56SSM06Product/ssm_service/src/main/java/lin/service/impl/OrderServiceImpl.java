package lin.service.impl;

import lin.dao.IOrderDao;
import lin.domain.Order;
import lin.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    IOrderDao orderDao;

    @Override
    public List<Order> findAllOrder() {
        List<Order> orders = orderDao.findAllOrder();
        return orders;
    }

    @Override
    public List<Order> findOrderWithProduct() {
        return orderDao.findOrderWithProduct();
    }

    @Override
    public Order findOrderWithMemberProductByOId(Integer oId) {
        Order order = orderDao.findOrderWithMemberProductByOId(oId);
        return order;
    }

    @Override
    public Order findOrderById(Integer oId) {
        Order order = orderDao.findOrderById(oId);
        return order;
    }

}
