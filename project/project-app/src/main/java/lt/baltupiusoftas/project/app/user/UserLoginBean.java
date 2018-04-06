package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;
import lt.baltupiusoftas.project.service.user.UserService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserLoginBean implements Serializable {

    private String email;
    private String password;
    private User user;

    @Inject
    private UserService userService;
    @Inject
    private PasswordHashingService passwordHashing;


    public void login () {
        user = userService.login(email, passwordHashing.hashPassword(password));
    }

    public void logout () {user = null;}

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
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
