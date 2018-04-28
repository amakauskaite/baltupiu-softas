package lt.baltupiusoftas.project.app;


import lt.baltupiusoftas.project.app.admin.AdminLoginBean;
import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.persistence.AdministratorDao;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * The ultimate bean
 *
 * @author Audrius Tvarijonas
 */
@Model
public class UltimateBean {
    @Inject
    AdministratorDao administratorDao;

    @Inject
    AdminLoginBean adminLoginBean;

    @Transactional
    public String helloWorld() {



        adminLoginBean.setUsername("admin");
        adminLoginBean.setPassword("secret");
        String result = adminLoginBean.login();

        return result;
    }
}
