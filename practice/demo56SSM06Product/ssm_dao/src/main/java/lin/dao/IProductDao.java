package lin.dao;

import lin.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface IProductDao {

    @Select("select * from product")
    List<Product> findAllProduct(Integer pageNum, Integer pageSize) throws Exception;

    @Insert("insert into product (productNum, productName, cityName, departuretime, productPrice, productDesc, productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product) throws Exception;

    @Select("select * from product where id = #{id}")
    public Product findProductById(Integer id);

}
