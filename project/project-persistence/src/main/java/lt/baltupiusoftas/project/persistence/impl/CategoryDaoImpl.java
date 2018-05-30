package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Cart;
import lt.baltupiusoftas.project.domain.Category;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Category DAO
 *
 * @author Audrius Tvarijonas
 */
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements lt.baltupiusoftas.project.persistence.CategoryDao {
    @Override
    public List<Category> findAll() {

        String allCategories = "select c from Category c ";
        return entityManager.createQuery(allCategories, Category.class).getResultList();
    }

    @Override
    public Category findByName(String name) {
        String byName = "select c from Category c where c.name = :name";
        TypedQuery<Category> query = entityManager.createQuery(byName, Category.class);
        query.setParameter("name", name);
        List<Category> cats = query.getResultList();
        if(!cats.isEmpty()) return cats.get(0);
        return null;
    }
}
