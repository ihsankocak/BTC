package info.ihsan.btc.springmvc.dao;

import info.ihsan.btc.model.Category;
import info.ihsan.btc.model.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository("productDao")
public class DefaultProductDao implements  ProductDao {
    @Autowired CategoryDao categoryDao;
    @Override
    public Product findById(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Product product=   entityManager.find(Product.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public void saveProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Collection<Product> findProductsOfCategory(String categoryId) {
       /* EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=   entityManager.createQuery("select c.products from Category c where c.id='"+categoryId+"'");

        Collection<Product> products=    query.getResultList();
        return products;*/
        Category category=categoryDao.findById(categoryId);
        return category.getProducts();
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        DefaultProductDao.entityManagerFactory = entityManagerFactory;
    }

    private static EntityManagerFactory entityManagerFactory;
    public DefaultProductDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("btcPu");
    }
}
