package lt.baltupiusoftas.project.app;

import javax.enterprise.context.SessionScoped;
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