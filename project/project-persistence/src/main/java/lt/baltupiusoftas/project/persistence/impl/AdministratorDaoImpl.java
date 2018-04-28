package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Administrator;
import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.persistence.AdministratorDao;

import javax.persistence.TypedQuery;

/**
 * Administrator DAO
 *
 * @author Audrius Tvarijonas
 */
public class AdministratorDaoImpl extends GenericDaoImpl<Administrator> implements AdministratorDao{
    @Override
    public Administrator findByUsername(String username) {
        String findAdmin = "select a " +
                "from Administrator a " +
                "where a.username = :username";

        TypedQuery<Administrator> query = entityManager.createQuery(findAdmin, Administrator.class);
        query.setParameter("username", username);
        Administrator administrator = query.getSingleResult();
        return administrator;
    }
}
