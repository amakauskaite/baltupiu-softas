package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Administrator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AdminRepositoryImpl extends GenericDaoImpl<Administrator> implements AdminRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Administrator findByUsername(String username) {
        return (Administrator) em.createNamedQuery("Administrator.findByUsername")
                .setParameter("username", username)
                .getSingleResult();
    }

}
