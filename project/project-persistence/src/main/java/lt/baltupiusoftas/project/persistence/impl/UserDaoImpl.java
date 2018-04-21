package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.User;
import lt.baltupiusoftas.project.persistence.UserDao;
import lt.baltupiusoftas.project.persistence.impl.GenericDaoImpl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * User DAO
 *
 * @author Audrius Tvarijonas
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    @Override
    public User findByEmail(String email) {
        User user = null;
        String findUserByEmail = "select u " +
                "from User u " +
                "where u.email = :email";

        TypedQuery<User> query = entityManager.createQuery(findUserByEmail, User.class);
        query.setParameter("email", email);
        try {
            user = query.getSingleResult();
        } catch (NoResultException ignored){

        }
        return user;
    }
}
