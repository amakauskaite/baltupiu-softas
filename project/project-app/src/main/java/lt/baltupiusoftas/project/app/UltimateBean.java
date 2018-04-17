package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.app.admin.AdminLoginBean;
import lt.baltupiusoftas.project.domain.*;
import lt.baltupiusoftas.project.persistence.*;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * The ultimate bean
 *
 * @author Audrius Tvarijonas
 */
@Model
public class UltimateBean {

    @Inject
    private AdministratorDao administratorDao;

    @Inject
    private AdminLoginBean adminLoginBean;

    @Transactional
    public String helloWorld() {

//        Administrator administrator = new Administrator();
//        administrator.setUsername("admin");
//        administrator.setPassword("5ebe2294ecd0e0f08eab7690d2a6ee69");
//        administratorDao.create(administrator);

        adminLoginBean.setUsername("admin");
        adminLoginBean.setPassword("secret");
        adminLoginBean.login();

        return "Logined" +  adminLoginBean.getAdministrator().getUsername();
    }
}
