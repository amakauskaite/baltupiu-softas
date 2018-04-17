package lt.baltupiusoftas.project.app.admin;

import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.service.admin.AdminService;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped("adminLoginBean")
public class AdminLoginBean {

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
        this.password = password;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public void login () {
        administrator = adminService.login(username, passwordHashingService.hashPassword(password));
    }

    public void logout () {
        administrator = null;
    }
}
