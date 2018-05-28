package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.app.AdministratorLogin;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.CategoryService;
import lt.baltupiusoftas.project.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Model
public class UpdateProductBean {
    @Inject
    private ProductService productService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private AdministratorLogin administratorLogin;
    private Long productId;
    private Product updatedProduct;

    private String categoryName;
    private String name;
    private String sku;
    private String photo;
    private BigDecimal price;
    private String Summary;

    public boolean isCreate() {
        return create;
    }

    private boolean create;


    @Transactional(Transactional.TxType.REQUIRED)
    @PostConstruct
    public void setup(){
        if(administratorLogin.getAdministrator() == null)
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            }
            catch (IOException ioe)
            {
                System.out.println("Failed to redirect to another page in "+this.getClass().getName());
            }
        }
        Map<String,String> params = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        String param = params.get("upId");
        if(param!=null) {
            productId =  Long.parseLong(param);
            updatedProduct = productService.productById(productId);
        }
        else create = true;
        updatedProduct = new Product();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void updateProduct(){
        Map<String,String> params = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        String param = params.get("updatedId");
        if(param!=null) productId =  Long.parseLong(param);
        if(productId!=null)
        {
            Product product = productService.productById(productId);
            product.setName(updatedProduct.getName());
            product.setPhoto(updatedProduct.getPhoto());
            product.setPrice(updatedProduct.getPrice());
            product.setSKU(updatedProduct.getSKU());
            product.setSummary(updatedProduct.getSummary());
            if (!categoryName.isEmpty()) product.setCategory(categoryService.addCategory(categoryName));
            else product.setCategory(null);
//            if (!updatedProduct.getName().isEmpty()) product.setName(updatedProduct.getName());
//            if (!updatedProduct.getPhoto().isEmpty()) product.setPhoto(updatedProduct.getPhoto());
//            if (updatedProduct.getPrice() != null) product.setPrice(updatedProduct.getPrice());
//            if (!updatedProduct.getSKU().isEmpty()) product.setSKU(updatedProduct.getSKU());
//            if (!updatedProduct.getSummary().isEmpty()) product.setSummary(updatedProduct.getSummary());
//            if (!categoryName.isEmpty()) product.setCategory(categoryService.addCategory(categoryName));
            if(productService.update(product)!=null);//todo show msg kad gerai
        }
        else ;//todo show msg kad blogai
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }
}
