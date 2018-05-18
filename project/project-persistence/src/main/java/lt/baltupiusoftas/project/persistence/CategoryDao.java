package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Category;

import java.util.List;

/**
 * Category DAO
 *
 * @author Audrius Tvarijonas
 */
public interface CategoryDao extends GenericDao<Category> {
    List<Category> findAll();
}
