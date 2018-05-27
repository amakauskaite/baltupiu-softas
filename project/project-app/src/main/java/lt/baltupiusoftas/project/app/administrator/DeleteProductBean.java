package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.ProductService;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class DeleteProductBean {
    @Inject
    private ProductService productService;

    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteProduct(){
        Map<String,String> params = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        String param = params.get("delId");
        if(param!=null) {
            Long productId = Long.parseLong(param);
            Product product = productService.productById(productId);
            productService.deleteProduct(product);
        }
    }

    public String redraw(){
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("form:dataTable");
        return "adminIndex";
    }
}
