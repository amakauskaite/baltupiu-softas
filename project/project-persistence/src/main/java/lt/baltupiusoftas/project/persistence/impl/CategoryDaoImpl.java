package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Category;

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
}
