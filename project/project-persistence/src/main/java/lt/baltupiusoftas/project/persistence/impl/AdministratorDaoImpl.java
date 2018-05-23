package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.persistence.AdministratorDao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Administrator DAO
 *
 * @author Audrius Tvarijonas
 */
public class AdministratorDaoImpl extends GenericDaoImpl<Administrator> implements AdministratorDao{
    @Override
    public Administrator findByUsername(String username) {
        Administrator administrator = null;
        String findAdmin = "select a " +
                "from Administrator a " +
                "where a.username = :username";
        TypedQuery<Administrator> query = entityManager.createQuery(findAdmin, Administrator.class);
        query.setParameter("username", username);
        try {

            administrator = query.getSingleResult();
        } catch (NoResultException ignored) {

        }
        return administrator;
    }
}
