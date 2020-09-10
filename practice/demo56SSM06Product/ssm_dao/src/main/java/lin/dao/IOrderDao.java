package lin.dao;

import lin.domain.Member;
import lin.domain.Order;
import lin.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Repository
public interface IOrderDao  {

    @Select("select * from orders")
    List<Order> findAllOrder() ;

    @Select("select * from orders")
    @Results({
            @Result(id = true, column = "oid" , property = "oid"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", javaType = Product.class,
                    one = @One(select = "lin.dao.IProductDao.findProductById", fetchType = FetchType.EAGER))
    })
    List<Order> findOrderWithProduct() ;

    @Select("select * from orders where oid = #{oId}")
    @Results({
            @Result(id = true, column = "oid" , property = "oid"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "memberid", property = "member", javaType = Member.class, one = @One(select = "lin.dao.IMemberDao.findMemberById", fetchType = FetchType.EAGER)),
            @Result(column = "productid", property = "product", javaType = Product.class, one = @One(select = "lin.dao.IProductDao.findProductById", fetchType = FetchType.EAGER)),
            @Result(column = "oid", property = "travellers", javaType = java.util.List.class, many = @Many(select = "lin.dao.ITravellerDao.findTravellersByOrderId", fetchType = FetchType.LAZY))
    })
    Order findOrderWithMemberProductByOId(Integer oId);

    @Select("select * from orders where oid = #{oid}")
    Order findOrderById(Integer oId);
}
