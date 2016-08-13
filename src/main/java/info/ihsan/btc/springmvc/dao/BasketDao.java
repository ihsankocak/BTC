package info.ihsan.btc.springmvc.dao;

import info.ihsan.btc.model.Basket;

import java.util.List;


public interface BasketDao {
    Basket findById(String id);
    List<Basket> findAllBaskets();
    void saveBasket(Basket basket);
}
