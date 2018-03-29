package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.user.UserService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class UserBean {

    @Inject
    private UserService userService;

    //TODO change to xhtml field values
    //TODO add @s
    public User login (String email, String password ) {
        return userService.login(email, password);
    }
    public User register(String email, String password, String firstname, String lastname, Integer phoneNumber) {
        //TODO add password hashing
        return userService.register(email, password, firstname, lastname, phoneNumber);
    }
}
