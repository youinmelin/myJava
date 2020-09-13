package lin.service.impl;

import com.github.pagehelper.PageHelper;
import lin.dao.IProductDao;
import lin.domain.Product;
import lin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  //加事务
public class ProductServiveImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAllProduct(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//(页码值，每页显示条数)
        return productDao.findAllProduct(pageNum, pageSize);
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        productDao.saveProduct(product);
    }

}
