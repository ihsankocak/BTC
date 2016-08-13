package info.ihsan.btc.springmvc.dao;



import info.ihsan.btc.model.Product;


import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ProductDao {
    Product findById(String id);

    void saveProduct(Product product);



    Collection<Product> findProductsOfCategory(String categoryId);
}
