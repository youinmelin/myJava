package lin;

import lin.dao.IProductDao;
import lin.domain.Product;
import lin.domain.UserInfo;
import lin.service.IProductService;
import lin.service.IUserService;
import lin.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.List;

public class TestService {

    ApplicationContext ac;
    IProductService productService;
    IUserService userService;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("classpath:applicationContextService.xml");
        productService = ac.getBean(IProductService.class);
        userService = ac.getBean(IUserService.class);
    }

    @Test
    public void testFindAllProduct() throws Exception {

        List<Product> products = productService.findAllProduct(1,5);
        for (Product product: products) {
            System.out.println(product); }
    }

    @Test
    public void testSaveProduct() throws Exception {

        Product product = new Product();
        product.setProductNum("BJ-1");
        product.setProductName("BJ");
        product.setCityName("北京");
//        product.setDepartureTimeStr("2011-12-04 13:55:00");
//        product.setDepartureTime(DateUtils.stringToDate("2011-12-04 13:55:00", ""));
        product.setDepartureTime(new Date());
        product.setProductPrice(2000D);
        product.setProductDesc("come");
        product.setProductStatus(1);
        productService.saveProduct(product);
    }

}
