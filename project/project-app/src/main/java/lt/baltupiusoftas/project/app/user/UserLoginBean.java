package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;
import lt.baltupiusoftas.project.service.user.UserService;

import javax.enterprise.context.SessionScoped;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
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

    @Transactional(Transactional.TxType.REQUIRED)
    public String login () {
        if (user == null) {
            user = userService.login(email, password);
            if (user == null) {
                return "error_login_user_do_not_exist";

            } else {
                return "success_login_user";
            }

        }
        return "error_login_user_is_not_null";
        }

    public String logout () {
        user = null;
        email = null;
        password = null;
        return "success_logout_user";

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        email = user.getEmail();
    }
}
