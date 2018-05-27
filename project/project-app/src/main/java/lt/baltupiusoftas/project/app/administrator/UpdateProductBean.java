package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.CategoryService;
import lt.baltupiusoftas.project.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class UpdateProductBean {
    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;
    private Long productId;
    private Product updatedProduct;
    private String categoryName;

    @PostConstruct
    public void setUp() {
        Map<String,String> params = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        String param = params.get("updatedId");
        if(param!=null) productId =  Long.parseLong(param);
        updatedProduct = new Product();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void updateProduct(){
        if(productId!=null)
        {
            Product product = productService.productById(productId);
            if (!updatedProduct.getName().isEmpty()) product.setName(updatedProduct.getName());
            if (!updatedProduct.getPhoto().isEmpty()) product.setPhoto(updatedProduct.getPhoto());
            if (updatedProduct.getPrice() != null) product.setPrice(updatedProduct.getPrice());
            if (!updatedProduct.getSKU().isEmpty()) product.setSKU(updatedProduct.getSKU());
            if (!updatedProduct.getSummary().isEmpty()) product.setSummary(updatedProduct.getSummary());
            if (!categoryName.isEmpty()) product.setCategory(categoryService.addCategory(categoryName));
            productService.update(product);
        }
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
