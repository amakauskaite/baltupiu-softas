package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;
import lt.baltupiusoftas.project.service.user.UserService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class HeaderStatusBean implements Serializable {

    private Boolean loginReg = true;
    private Boolean logoutUsr = false;

    public void showLoginAndRegistration() {
        setLoginReg(true);
        setLogoutUsr(false);
    }

    public void showLogoutAndUserProfile() {
        setLoginReg(false);
        setLogoutUsr(true);
    }

    public boolean isLoginReg() {
        return loginReg;
    }

    private void setLoginReg(boolean loginReg) {
        this.loginReg = loginReg;
    }

    public boolean isLogoutUsr() {
        return logoutUsr;
    }

    private void setLogoutUsr(boolean logoutUsr) {
        this.logoutUsr = logoutUsr;
    }
}