package lt.baltupiusoftas.project.app;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class AdminHeaderStatusBean implements Serializable {

    private Boolean loginAdm = true;
    private Boolean logoutAdm = false;

    public void showLoginAndRegistration() {
        setLoginAdm(true);
        setLogoutAdm(false);
    }

    public void showLogoutAndUserProfile() {
        setLoginAdm(false);
        setLogoutAdm(true);
    }

    public Boolean getLoginAdm() {
        return loginAdm;
    }

    public void setLoginAdm(Boolean loginAdm) {
        this.loginAdm = loginAdm;
    }

    public Boolean getLogoutAdm() {
        return logoutAdm;
    }

    public void setLogoutAdm(Boolean logoutAdm) {
        this.logoutAdm = logoutAdm;
    }
}