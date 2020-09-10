package lin.service;

import lin.domain.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface IOrderService {

    List<Order> findAllOrder() ;

    List<Order> findOrderWithProduct();

    Order findOrderWithMemberProductByOId(Integer oId);

    Order findOrderById (Integer oId);
}
