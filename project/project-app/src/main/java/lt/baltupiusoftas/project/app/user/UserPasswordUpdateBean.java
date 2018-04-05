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

    private Long id;
    private String oldPassword;
    private String newPassword;

    @Inject
    private UserService userService;
    @Inject
    private PasswordHashingService passwordHashing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public User updatePassword () {

        return userService.updatePassword(id, oldPassword, passwordHashing.hashPassword(newPassword));

    }
}
