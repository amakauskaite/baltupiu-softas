package lt.baltupiusoftas.project.app.user;


import lt.baltupiusoftas.project.app.HeaderStatusBean;
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


    @Inject
    HeaderStatusBean headerStatusBean;

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

            headerStatusBean.showLogoutAndUserProfile();
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

            headerStatusBean.showLoginAndRegistration();
            return "login";//success_logout_user
        } else {
            return "index";
        }
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
