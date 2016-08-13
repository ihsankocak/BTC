package info.ihsan.btc.springmvc.controller;


import info.ihsan.btc.model.Product;
import info.ihsan.btc.springmvc.service.CategoryService;
import info.ihsan.btc.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping(value = { "/category/{categoryId}"}, method = RequestMethod.GET)
    public String listProductsOfCategory(ModelMap model, @PathVariable String categoryId) {
        System.out.println("categoryid: "+categoryId);

        Collection<Product> products=service.findProductsOfCategory(categoryId);
        for(Product p:products) System.out.println("urunn:: "+p.getName());
        //System.out.println(products.size());
        model.addAttribute("products",products);
        return "products";
    }

    @RequestMapping(value = { "/{productId}"}, method = RequestMethod.GET)
    public String productDetail(ModelMap model, @PathVariable String productId) {
       Product product= service.findById(productId);
        model.addAttribute("product",product);
        return "product";
    }
    public ProductService getService() {
        return service;
    }

    public void setService(ProductService service) {
        this.service = service;
    }
}
