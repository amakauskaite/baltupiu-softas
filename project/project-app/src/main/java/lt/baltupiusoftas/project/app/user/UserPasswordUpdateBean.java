package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;
import lt.baltupiusoftas.project.service.user.UserService;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Model
public class UserPasswordUpdateBean implements Serializable {

    private String newPassword;

    private User user;

    @Inject
    private UserService userService;
    @Inject
    private PasswordHashingService passwordHashing;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void updatePassword () {

        user =  userService.updatePassword(user, passwordHashing.hashPassword(newPassword));

    }
}
