package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.domain.Category;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.CategoryService;
import lt.baltupiusoftas.project.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
@Model
public class CreateProductBean {
    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;
    private Product product;
    private Category category;
    private String categoryName;

    @PostConstruct
    private void setUp(){
        product = new Product();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void addProduct(){
        product.setCategory(addCategory());
        productService.add(product);
    }


    private Category addCategory(){
        if(category==null&&categoryName!=null)
        {
            Category cat = new Category();
            cat.setName(categoryName);
            return categoryService.add(cat);
        }
        else if(category!=null&&categoryName==null)
        {
            return category;
        }
        else return null;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
