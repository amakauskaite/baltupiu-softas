package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.persistence.UserDao;
import lt.baltupiusoftas.project.persistence.impl.GenericDaoImpl;

/**
 * User DAO
 *
 * @author Audrius Tvarijonas
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    @Override
    public User findByEmail(String email) {
        return null;
    }
}
