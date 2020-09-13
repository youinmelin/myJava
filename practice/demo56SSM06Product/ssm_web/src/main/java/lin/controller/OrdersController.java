package lin.controller;

import lin.domain.Order;
import lin.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    IOrderService orderService;

    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAllOrders() {

        List<Order> orders = orderService.findOrderWithProduct();
        System.out.println("USL: findAllOrder");
        ModelAndView mv = new ModelAndView();
        mv.addObject("ordersList", orders);
        mv.setViewName("orders-list");
        return mv ;
    }

    @RequestMapping("/findDetail.do")
    public ModelAndView findOrderDetail(@RequestParam (name = "oId", required = true) Integer oId) throws Exception{
        ModelAndView mv  = new ModelAndView();
        Order order = orderService.findOrderWithMemberProductByOId(oId);
        mv.addObject("orders", order);
        mv.setViewName("orders-show");
        return mv;
    }

    @RequestMapping("/findOrderById.do")
    public ModelAndView findOrderById(@RequestParam (name = "oId", required = true) Integer oId) throws Exception{
        Order order = orderService.findOrderById(oId);
//        Order order = orderService.findOrderWithMemberProductByOId(oId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders", order);
        mv.setViewName("orders-show");
        return mv;
    }
}
