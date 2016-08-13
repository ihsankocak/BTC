package info.ihsan.btc.springmvc.dao;

import info.ihsan.btc.model.Basket;
import info.ihsan.btc.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository("basketDao")
public class DefaultBasketDao implements BasketDao {
    private static EntityManagerFactory entityManagerFactory;
    public DefaultBasketDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("btcPu");
    }
    @Override
    public Basket findById(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Basket basket=   entityManager.find(Basket.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return basket;
    }

    @Override
    public List<Basket> findAllBaskets() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=   entityManager.createQuery("select b from Basket b");
        List<Basket> baskets=(List<Basket>)     query.getResultList();
        if(baskets==null)return new ArrayList<Basket>();
        return baskets;
    }

    @Override
    public void saveBasket(Basket basket) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(basket);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
