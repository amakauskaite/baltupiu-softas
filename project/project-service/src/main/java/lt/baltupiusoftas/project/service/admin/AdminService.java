package lt.baltupiusoftas.project.service.admin;

import lt.baltupiusoftas.project.domain.Administrator;

import java.io.Serializable;

public interface AdminService extends Serializable {

    Administrator login (String username, String password);
}
