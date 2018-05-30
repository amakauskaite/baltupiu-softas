package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Category;
import lt.baltupiusoftas.project.persistence.CategoryDao;
import lt.baltupiusoftas.project.service.CategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Inject
    private CategoryDao categoryDao;
    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category add(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryDao.findByName(name);
    }
    public Category addCategory(String name) {
        Category category = findByName(name);
        if(category==null)
        {
            category = new Category();
            category.setName(name);
            return add(category);
        }
        return category;
    }
}
