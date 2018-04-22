package lt.baltupiusoftas.project.app.user;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.password.PasswordHashingService;
import lt.baltupiusoftas.project.service.user.UserService;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;

@Model
public class UserPasswordUpdateBean implements Serializable {


    @Inject
    private UserService userService;
    @Inject
    private PasswordHashingService passwordHashing;
    @Inject
    private UserLoginBean userLoginBean;

    private String newPassword;

    private String oldPassword;

    private User user = userLoginBean.getUser();

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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void updatePassword () {

        user =  userService.updatePassword(user, passwordHashing.hashPassword(newPassword));

    }
}
