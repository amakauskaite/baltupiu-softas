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
    private Product product;
    private Product updatedProduct;
    private boolean createProduct;
    private String categoryName;

    @Transactional(Transactional.TxType.REQUIRED)
    @PostConstruct
    public void setUp() {
        product = null;
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params =
                fc.getExternalContext().getRequestParameterMap();
        String param = params.get("updateId");
        if(param!=null){
            Long id =  Long.parseLong(param);
            product = productService.productById(id);
        }
        createProduct = product == null;
        updatedProduct = new Product();
        if(createProduct) product = new Product();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void updateProduct(){
        //Product product = productService.productById(productId);
        if(!updatedProduct.getName().isEmpty()) product.setName(updatedProduct.getName());
        if(!updatedProduct.getPhoto().isEmpty()) product.setPhoto(updatedProduct.getPhoto());
        if(updatedProduct.getPrice()!=null) product.setPrice(updatedProduct.getPrice());
        if(!updatedProduct.getSKU().isEmpty()) product.setSKU(updatedProduct.getSKU());
        if(!updatedProduct.getSummary().isEmpty()) product.setSummary(updatedProduct.getSummary());
        if(!categoryName.isEmpty()) product.setCategory(categoryService.addCategory(categoryName));
        if(!createProduct) productService.update(product);
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
