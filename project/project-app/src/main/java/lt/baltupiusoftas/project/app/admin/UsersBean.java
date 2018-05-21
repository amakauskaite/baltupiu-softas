package lt.baltupiusoftas.project.app.admin;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.user.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Model
public class UsersBean {
    private List<User> users;
    @Inject
    private UserService userService;

    @Transactional(Transactional.TxType.REQUIRED)
    @PostConstruct
    public void getAll(){
        users = userService.getAllUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    public String blockOrUnblockUser(User user){
        User newUser = userService.changeBlockStatus(user.getId(), !user.getBlocked());
        users.set(users.indexOf(user), newUser);
        //register component for redraw
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("form:dataTable");
        //execute redraw
        return "userList";
    }
}
