package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.app.AdministratorLogin;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;

@Model
public class AdminProductList {
    @Inject
    private AdministratorLogin administratorLogin;


    @Transactional(Transactional.TxType.REQUIRED)
    public boolean isAdminLogged(){
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
