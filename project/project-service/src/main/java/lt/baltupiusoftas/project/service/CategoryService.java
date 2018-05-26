package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category add(Category category);
}
