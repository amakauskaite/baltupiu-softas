package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.domain.User;

import javax.enterprise.context.SessionScoped;
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

    // TODO implement temporary user for session

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
