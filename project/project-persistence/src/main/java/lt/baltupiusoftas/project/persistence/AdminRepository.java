package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Administrator;

public interface AdminRepository extends GenericDao <Administrator> {

    Administrator findByUsername (String username);
}
