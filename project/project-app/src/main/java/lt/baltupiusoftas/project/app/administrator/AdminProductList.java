package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.app.AdministratorLogin;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Map;

@Model
public class AdminProductList {
    @Inject
    private AdministratorLogin administratorLogin;
    private Product product;
    @Inject
    private ProductService productService;


    @Transactional(Transactional.TxType.REQUIRED)
    public boolean isAdminLoged(){
        if (administratorLogin.getAdministrator() == null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            } catch (IOException ioe) {
                System.out.println("Failed to redirect to another page in " + this.getClass().getName());
            }
        }
        return true;
    }
}
