package lt.baltupiusoftas.project.app.products;

import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@RequestScoped
@Model
public class ProductBean {

    @Inject
    private ProductService productService;

    private Product product;

    @Transactional(Transactional.TxType.REQUIRED)
    @PostConstruct
    public void getParams () {

        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params =
                fc.getExternalContext().getRequestParameterMap();
        String param = params.get("id");
        if(params!=null) {
            Long id = Long.parseLong(param);
            product = productService.productById(id);
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
