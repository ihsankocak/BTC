package info.ihsan.dao;

import info.ihsan.btc.model.Category;
import info.ihsan.btc.model.Product;
import info.ihsan.btc.springmvc.dao.CategoryDao;
import org.junit.AfterClass;
import   org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.*;


public class CategoryTest {

    private static EntityManagerFactory entityManagerFactory;
    @Autowired
    private CategoryDao dao;
    @BeforeClass
    public static void setUpEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("btcPu");
    }

    @AfterClass
    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void canPersistAndLoadCategoryAndProducts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Category category=new Category();
        category.setName("Category1");

        Product product1=new Product();
        product1.setName("Product1");
        product1.setPrice(10);
       // product1.setCategory(category);

        Product product2=new Product();
        product2.setName("Product2");
        product2.setPrice(20);
        //product2.setCategory(category);

        Collection<Product> products=new ArrayList<>();
        products.add(product1);
        products.add(product2);

        category.setProducts(products);
        entityManager.persist(category);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

Category loadedCategory=entityManager.find(Category.class, category.getId());
        Assert.assertNotNull(loadedCategory);
        Assert.assertNotNull(loadedCategory.getProducts());
        Assert.assertEquals(category.getName(),"Category1");
        Assert.assertEquals(category.getProducts().size(),2);

        entityManager.getTransaction().commit();
        entityManager.close();

   /*    List<Category> categories= dao.findAllCategories();
        System.out.println(categories.get(0).getName());*/
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        CategoryTest.entityManagerFactory = entityManagerFactory;
    }

    public CategoryDao getCategoryDao() {
        return dao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.dao = categoryDao;
    }
}
