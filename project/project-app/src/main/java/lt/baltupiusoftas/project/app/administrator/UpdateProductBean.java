package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.domain.Category;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.CategoryService;
import lt.baltupiusoftas.project.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@RequestScoped
@Model
public class UpdateProductBean {
    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;
    private Product product;
    private Product updatedProduct;
    private boolean createProduct;
    private String categoryName;

    @Transactional(Transactional.TxType.REQUIRED)
    @PostConstruct
    public void setUp() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params =
                fc.getExternalContext().getRequestParameterMap();
        String param = params.get("updateId");
        Long id =  Long.parseLong(param);
        product = productService.productById(id);
        createProduct = product == null;
        updatedProduct = new Product();
        if(createProduct) product = new Product();
    }

    public void updateProduct(){
        if(updatedProduct.getName()!=null) product.setName(updatedProduct.getName());
        if(updatedProduct.getPhoto()!=null) product.setPhoto(updatedProduct.getPhoto());
        if(updatedProduct.getPrice()!=null) product.setPrice(updatedProduct.getPrice());
        if(updatedProduct.getSKU()!=null) product.setSKU(updatedProduct.getSKU());
        if(updatedProduct.getSummary()!=null) product.setSummary(updatedProduct.getSummary());
        if(updatedProduct.getCategory()!=null) product.setCategory(updatedProduct.getCategory());
        else if(categoryName!=null) product.setCategory(addNewCategory());
        update();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    private Category addNewCategory() {
        Category cat = new Category();
        cat.setName(categoryName);
        return categoryService.add(cat);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    private void update(){
        productService.update(product);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public boolean isCreateProduct() {
        return createProduct;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Product getUpdatedProduct() {
        return updatedProduct;
    }

    public void setUpdatedProduct(Product updatedProduct) {
        this.updatedProduct = updatedProduct;
    }
}
