package lt.baltupiusoftas.project.app.administrator;

import lt.baltupiusoftas.project.app.AdministratorLogin;
import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.service.AdministratorService;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@Named
@SessionScoped
public class AdministratorLoginBean implements Serializable {

    @Inject
    private AdministratorLogin adminLogin;

    private String username;
    private String password;

    @Inject
    private AdministratorService adminService;

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

            return "index";
        } else {
            Administrator administrator = adminService.login(username, password);
            if (administrator == null) {
                adminLogin.setAdministrator(administrator);
                return "login";
            } else {
                return "index";
            }

        }


        }
    private Boolean isLoggedIn() {
        return adminLogin.getAdministrator() != null;
    }


    public String logout () {
        if (isLoggedIn()) {
            adminLogin.setAdministrator(null);
            return "login";

        } else {
            return "index";
        }
    }
}