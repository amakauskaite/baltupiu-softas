package lt.baltupiusoftas.project.app.admin;

import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.service.admin.AdminService;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;

import javax.enterprise.context.SessionScoped;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@Named
@SessionScoped
public class AdminLoginBean implements Serializable {

    private String username;
    private String password;
    private Administrator administrator;

    @Inject
    private AdminService adminService;

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

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public String login () {
        if (administrator == null) {
            administrator = adminService.login(username, password);
            if (administrator == null) {
                return "error_login_administrator_does_not_exist";
            }
            return "success_login_administrator";
        }

        return "error_login_administrator_is_not_null";
    }

    public void logout () {
        administrator = null;
        username = null;
        password = null;
    }
}
