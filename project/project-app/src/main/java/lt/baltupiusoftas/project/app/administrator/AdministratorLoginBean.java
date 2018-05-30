package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.app.AdminHeaderStatusBean;
import lt.baltupiusoftas.project.app.AdministratorLogin;
import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.service.AdministratorService;
import lt.baltupiusoftas.project.service.LoggerService;
import lt.baltupiusoftas.project.service.intersector.LoggedInvocation;
import lt.baltupiusoftas.project.service.PasswordHashingService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@Named
@RequestScoped
@LoggedInvocation
public class AdministratorLoginBean{

    @Inject
    private AdministratorLogin adminLogin;

    private String username;
    private String password;

    @Inject
    private AdminHeaderStatusBean adminHeaderStatusBean;

    @Inject
    private AdministratorService adminService;

    @Inject
    private LoggerService loggerService;

    @Inject
    private PasswordHashingService passwordHashingService;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = passwordHashingService.hashPassword(password);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public String login () {

        if (isLoggedIn()) {

            return "adminIndex";
        } else {
            Administrator administrator = adminService.login(username, password);
            if (administrator == null) {
                FacesContext.getCurrentInstance().addMessage("loginBtn", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Klaida!",  "Vartotojas neegzistuoja arba blogi duomenys"));
                return "admin";
            } else {
                adminLogin.setAdministrator(administrator);
                loggerService.setUserAndIsAdmin(username, true);

                adminHeaderStatusBean.showLogoutAndUserProfile();
                return "adminIndex";
            }

        }


        }
    private Boolean isLoggedIn() {
        return adminLogin.getAdministrator() != null;
    }


    public String logout () {
        if (isLoggedIn()) {
            loggerService.setUserAndIsAdmin(null, false);
            adminLogin.setAdministrator(null);
            adminHeaderStatusBean.showLoginAndRegistration();
            return "admin";

        } else {
            return "adminIndex";
        }
    }
}