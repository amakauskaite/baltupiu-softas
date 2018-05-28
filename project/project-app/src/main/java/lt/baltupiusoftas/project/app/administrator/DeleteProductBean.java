package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.app.AdministratorLogin;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Map;

@Model
public class DeleteProductBean {
    @Inject
    private ProductService productService;

    @Inject
    private AdministratorLogin administratorLogin;

    @PostConstruct
    public void checkLogin()
    {
        // if administrator is not logged in, redirect to error page
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
    }


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String deleteProduct(){
        Map<String,String> params = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        String param = params.get("delId");
        if(param!=null) {
            // if product found, delete it
            Long productId = Long.parseLong(param);
            productService.deleteProduct(productId);
            FacesContext.getCurrentInstance().addMessage("deleteBtn", new FacesMessage(FacesMessage.SEVERITY_INFO,"Sėkmė",  "Prekė sėkmingai pašalinta"));
        }
        else
        {
            // else - show error message
            FacesContext.getCurrentInstance().addMessage("deleteBtn", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Klaida!",  "Prekės nepavyko pašalinti."));
        }
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(":form:dataTable");
        return "adminIndex";
    }
}
