package lt.baltupiusoftas.project.app;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.persistence.UserDao;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class UltimateBean {

    @Inject
    private UserDao userDao;

    @Transactional
    public String helloWorld() {

        userDao.create(new User());

        return "Hello World!";
    }
}
