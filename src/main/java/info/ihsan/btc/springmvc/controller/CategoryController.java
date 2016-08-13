package info.ihsan.btc.springmvc.controller;

import info.ihsan.btc.springmvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CategoryController {
    @Autowired
    CategoryService service;

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        model.addAttribute("categories",service.findAllCategories());
        return "categories";
    }


}
