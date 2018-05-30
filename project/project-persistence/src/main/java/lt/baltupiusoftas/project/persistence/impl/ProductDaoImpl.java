package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Category;
import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.persistence.ProductDao;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Product DAO
 *
 * @author Audrius Tvarijonas
 * & me
 */
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao{

    @Inject
    private CategoryDaoImpl categoryDao;

    @Override
    public List<Product> findBlockOfProducts(int blockSize) {
        String blockOfProductsQuery = "select p" +
                                    " from Product p" +
                                    " order by p.lastUpdated desc";
        TypedQuery<Product> query = entityManager.createQuery(blockOfProductsQuery, Product.class)
                                                 .setMaxResults(blockSize);
        return query.getResultList();
    }

    @Override
    public List<Product> findAllProducts() {
        String allProducts = "select p from Product p where p.active = true";
        return entityManager.createQuery(allProducts, Product.class).getResultList();
    }

    @Override
    public int numberOfProducts() {
        String numberOfProducts = "select count(p.id) from Product p";
        return (Integer)entityManager.createNativeQuery(numberOfProducts, Product.class).getSingleResult();
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        Category category = categoryDao.find(categoryId);
        String allProducts = "select p from Product p where p.category = :category  AND p.active = true ";
        if (category != null) {
            return  entityManager.createQuery(allProducts, Product.class).setParameter("category", category).getResultList();
        }
        return null;
    }
}
