package lt.baltupiusoftas.project.app.admin;

import lt.baltupiusoftas.project.app.AdministratorLogin;
import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RequestScoped
@Model
public class UsersBean {
    private List<User> users;
    @Inject
    private UserService userService;
    @Inject
    private AdministratorLogin administratorLogin;

    @Transactional(Transactional.TxType.REQUIRED)
    @PostConstruct
    public void getAll(){
        if(administratorLogin.getAdministrator() == null)
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
            }
            catch (IOException ioe)
            {
                System.out.println("Failed to redirect to another page in "+this.getClass().getName());
            }
        }
        users = userService.getUserList();
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
