package info.ihsan.btc.springmvc.service;


import info.ihsan.btc.model.Category;
import info.ihsan.btc.springmvc.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class DefaultCategoryService implements CategoryService{
    @Autowired
    private CategoryDao dao;
    @Override
    public Category findById(String id) {
        return dao.findById(id);
    }

    @Override
    public void saveCategory(Category category) {
dao.saveCategory(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return dao.findAllCategories();
    }
}
