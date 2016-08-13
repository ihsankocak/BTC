package info.ihsan.btc.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Basket {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;



    @ElementCollection
    private Map<String,Integer> basketItemMap=new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Integer> getBasketItemMap() {
        return basketItemMap;
    }

    public void setBasketItemMap(Map<String, Integer> basketItemMap) {
        this.basketItemMap = basketItemMap;
    }
}
