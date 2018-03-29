package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.User;

public interface UserRepository  extends GenericDao<User>  {

    User findByEmail (String email);
}
