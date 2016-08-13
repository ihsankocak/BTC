package info.ihsan.btc.springmvc.dao;


import info.ihsan.btc.model.Category;

import java.util.List;

public interface CategoryDao {
    Category findById(String id);

    void saveCategory(Category category);



    List<Category> findAllCategories();


}
