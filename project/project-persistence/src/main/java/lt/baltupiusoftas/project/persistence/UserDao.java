package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.User;

import java.util.List;

/**
 * User DAO
 *
 * @author Audrius Tvarijonas
 */
public interface UserDao extends GenericDao<User> {

    /**
     * Fins user by email
     *
     * @param email email
     * @return user
     */
    User findByEmail(String email);
    List<User> findAll();

    List<User> findNotEmpty();
}
