package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.password.PasswordHashing;
import lt.baltupiusoftas.project.service.user.UserService;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;

@Model
@SessionScoped
public class UserPasswordUpdateBean implements Serializable {

    private Long id;
    private String oldPassword;
    private String newPassword;

    @Inject
    private UserService userService;
    @Inject
    private PasswordHashing passwordHashing;

    public User updatePassword () {
        return userService.updatePassword(id, oldPassword, passwordHashing.hashPassword(newPassword));

    }
}
