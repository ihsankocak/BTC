package info.ihsan.btc.springmvc.service;

import info.ihsan.btc.model.Product;
import info.ihsan.btc.springmvc.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service("productService")
@Transactional
public class DefaultProductService implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public Product findById(String id) {
        return productDao.findById(id);
    }

    @Override
    public void saveProduct(Product product) {
    productDao.saveProduct(product);
    }

    @Override
    public Collection<Product> findProductsOfCategory(String categoryId) {
     return    productDao.findProductsOfCategory(categoryId);
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
