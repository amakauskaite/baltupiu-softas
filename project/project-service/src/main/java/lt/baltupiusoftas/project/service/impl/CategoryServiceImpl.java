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
}
