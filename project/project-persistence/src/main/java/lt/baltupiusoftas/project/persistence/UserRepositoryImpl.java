package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserRepositoryImpl extends GenericDaoImpl<User> implements UserRepository  {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User findByEmail(String email) {
        return (User) em.createNamedQuery("User.findByEmail")
                .setParameter("email", email)
                .getSingleResult();
    }


}
