package lt.baltupiusoftas.project.app.products.category;

import lt.baltupiusoftas.project.domain.Category;
import lt.baltupiusoftas.project.service.CategoryService;
import lt.baltupiusoftas.project.service.intersector.LoggedInvocation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CategoryBean {

    @Inject
    private CategoryService categoryService;

    private List<Category> categories;
    private Category category;

    @PostConstruct
    public void findAllCategories () {
        this.categories = categoryService.findAllCategories();

    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
