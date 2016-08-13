package info.ihsan.btc.springmvc.service;


import info.ihsan.btc.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(String id);

    void saveCategory(Category category);



    List<Category> findAllCategories();
}
