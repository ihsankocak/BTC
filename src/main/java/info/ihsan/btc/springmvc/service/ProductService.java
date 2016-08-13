package info.ihsan.btc.springmvc.service;

import info.ihsan.btc.model.Product;

import java.util.Collection;
import java.util.List;
import java.util.Set;


public interface ProductService {
    Product findById(String id);

    void saveProduct(Product product);



    Collection<Product> findProductsOfCategory(String categoryId);
}
