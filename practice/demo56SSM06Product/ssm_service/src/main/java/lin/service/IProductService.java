package lin.service;

import lin.domain.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAllProduct(Integer pageNum, Integer pageSize) throws Exception;

    void saveProduct(Product product) throws Exception;
}
