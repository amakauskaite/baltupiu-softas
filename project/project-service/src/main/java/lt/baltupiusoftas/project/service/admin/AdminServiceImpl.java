package lt.baltupiusoftas.project.service.admin;

import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.persistence.AdminRepository;

import javax.inject.Inject;

public class AdminServiceImpl implements AdminService {

    @Inject
    private AdminRepository adminRepository;

    @Override
    public Administrator login(String username, String password) {
        Administrator admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password) ) {
            return admin;
        }
        //TODO maybe error?
        return null;
    }
}
