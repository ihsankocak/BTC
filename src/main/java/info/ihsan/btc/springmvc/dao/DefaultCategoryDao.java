package info.ihsan.btc.springmvc.dao;

import info.ihsan.btc.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


@Repository("categoryDao")
public class DefaultCategoryDao implements  CategoryDao {
    private static EntityManagerFactory entityManagerFactory;
    public DefaultCategoryDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("btcPu");
    }

    @Override
    public Category findById(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
     Category category=   entityManager.find(Category.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return category;
    }

    @Override
    public void saveCategory(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        DefaultCategoryDao.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Category> findAllCategories() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
     Query query=   entityManager.createQuery("select c from Category c");
        List<Category> categories=(List<Category>)     query.getResultList();
        return categories;
    }
}
