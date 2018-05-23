package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.persistence.AdministratorDao;
import lt.baltupiusoftas.project.service.AdministratorService;

import javax.inject.Inject;

public class AdministratorServiceImpl implements AdministratorService {

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
