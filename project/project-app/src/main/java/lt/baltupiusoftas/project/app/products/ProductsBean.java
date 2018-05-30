package lt.baltupiusoftas.project.app.products;

import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.ProductService;
import lt.baltupiusoftas.project.service.intersector.LoggedInvocation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
@LoggedInvocation
public class ProductsBean {
    private List<Product> products;

    @Inject
    private ProductService productService;


    @Transactional(Transactional.TxType.REQUIRED)
    @PostConstruct
    public void getParams () {

        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params =
                fc.getExternalContext().getRequestParameterMap();
        String param = params.get("id");
        if (param != null) {
            Long id =  Long.parseLong(param);
            products = productService.findByCategory(id);

        }
        else {
            products = productService.findAll();
        }
    }

    public List<Product> getProducts(){
    return products;
    }
}
