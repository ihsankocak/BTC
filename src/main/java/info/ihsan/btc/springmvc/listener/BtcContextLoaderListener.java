package info.ihsan.btc.springmvc.listener;

import info.ihsan.btc.model.Basket;
import info.ihsan.btc.springmvc.dao.BasketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;


@Component
public class BtcContextLoaderListener extends ContextLoaderListener {
    @Autowired
   private BasketDao basketDao;
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        if(basketDao.findAllBaskets().size()<1)basketDao.saveBasket(new Basket());
    }

}
