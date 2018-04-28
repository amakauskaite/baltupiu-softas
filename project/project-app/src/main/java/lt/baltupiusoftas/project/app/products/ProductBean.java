package lt.baltupiusoftas.project.app.products;

import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.Products.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Model
public class ProductBean {
    //paimt prekiu sarasa
    //surasti viena preke
    private List<Product> products;
    private Product product;

    @Inject
    private ProductService productService;


    @Transactional
    public List<Product> showAllProducts(){
        products = productService.findAll();
        return products;
    }

    //get product by id?

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public List<Product> getProducts(){
    return products;
    }
}
