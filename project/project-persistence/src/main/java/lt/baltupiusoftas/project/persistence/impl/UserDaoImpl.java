package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.persistence.UserDao;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User DAO
 *
 * @author Audrius Tvarijonas
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    @Override
    public User findByEmail(String email) {
        String findUserByEmail = "select u " +
                "from User u " +
                "where u.email = :email";

        TypedQuery<User> query = entityManager.createQuery(findUserByEmail, User.class);
        query.setParameter("email", email);

        List<User> user = query.getResultList();
        if (!user.isEmpty()) {
            return user.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        String findAll = "select u from User u";
        TypedQuery<User> query = entityManager.createQuery(findAll, User.class);
        return query.getResultList();
    }

    @Override
    public List<User> findNotEmpty() {
        String findAll = "select u from User u where u.email is not null";
        TypedQuery<User> query = entityManager.createQuery(findAll, User.class);
        return query.getResultList();
    }
}
