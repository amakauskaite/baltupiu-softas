package lt.baltupiusoftas.project.app.products.category;

import lt.baltupiusoftas.project.domain.Category;
import lt.baltupiusoftas.project.service.CategoryService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
@RequestScoped
public class CategoryBean {

    @Inject
    private CategoryService categoryService;

    private List<Category> categories;

    @Transactional
    public void findAllCategories () {
        categories = categoryService.findAllCategories();

    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}