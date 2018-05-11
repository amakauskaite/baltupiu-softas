package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.app.Login;
import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;
import lt.baltupiusoftas.project.service.user.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class UserLoginBean implements Serializable {

    /*
     * Session scoped login bean
     */
    @Inject
    private Login login;

    private String email;

    private String password;

    private Boolean loginReg = true;
    private Boolean logoutUsr = false;


    @Inject
    private UserService userService;

    @Inject
    private PasswordHashingService passwordHashing;

    public String login() {
        // Ignore if logged in already
        if (isLoggedIn()) {
            return "index";
        }
        User user = userService.login(email, password);
        // If user is registered and login successful
        if (user != null) {
            login.setUser(user);
            showLogoutAndUserProfile();
            return "index";
        }
        // If user is not registered and login failed
        else {
            FacesContext.getCurrentInstance().addMessage("loginBtn", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Klaida!",  "Vartotojas neegzistuoja arba blogi duomenys"));
            return "login";
        }
    }

    public String logout() {
        if (isLoggedIn()) {
            login.setUser(null);
            showLoginAndRegistration();
            return "login";//success_logout_user
        } else {
            return "index";
        }
    }

    public void showLoginAndRegistration(){
        loginReg = true;
        logoutUsr = false;
    }

    public void showLogoutAndUserProfile()
    {
        loginReg = false;
        logoutUsr = true;
    }

    public boolean isLoginReg() {
        return loginReg;
    }

    public void setLoginReg(boolean loginReg) {
        this.loginReg = loginReg;
    }

    public boolean isLogoutUsr() {
        return logoutUsr;
    }

    public void setLogoutUsr(boolean logoutUsr) {
        this.logoutUsr = logoutUsr;
    }

    private Boolean isLoggedIn() {
        return login.getUser() != null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = passwordHashing.hashPassword(password);
    }
}
