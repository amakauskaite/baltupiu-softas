package lt.baltupiusoftas.project.service.admin;

import lt.baltupiusoftas.project.domain.Administrator;

import java.io.Serializable;

public interface AdminService {

    Administrator login (String username, String password);
}
