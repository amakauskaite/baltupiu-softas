package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Named;
import java.io.Serializable;

/**
 * User bean
 *
 * @author Audrius Tvarijonas
 */
@Named
@SessionScoped
public class Login implements Serializable {

    private User user;

    @PostConstruct
    private void init() {
        UserService userService = CDI.current().select(UserService.class).get();
        user = userService.initTemporaryUser();
    }

    @PreDestroy
    private void terminate() {
        UserService userService = CDI.current().select(UserService.class).get();
        userService.deleteUser(user.getId());
    }

    public Boolean isLoggedIn() {
        return user.getEmail() != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
