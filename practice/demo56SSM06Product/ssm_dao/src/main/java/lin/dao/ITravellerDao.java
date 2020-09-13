package lin.dao;

import lin.domain.Traveller;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITravellerDao {

    @Select("select * from traveller where tid = #{tid}")
    Traveller findTravellerById(Integer tid);

    @Select("select t.* from traveller t left join order_traveller ot on orderid = #{oid} and t.tid = travellerid")
//    @Select("select * from traveller where tid in (select travellerId from order_traveller where orderId=#{oId})")
    List<Traveller> findTravellersByOrderId(Integer oId);


}
