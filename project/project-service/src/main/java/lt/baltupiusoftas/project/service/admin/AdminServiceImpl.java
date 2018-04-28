package lt.baltupiusoftas.project.service.admin;

import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.persistence.AdministratorDao;

import javax.inject.Inject;

public class AdminServiceImpl implements AdminService {

    @Inject
    private AdministratorDao administratorDao;

    @Override
    public Administrator login(String username, String password) {
        Administrator admin = administratorDao.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password) ) {
            return admin;
        }
        return null;
    }
}
