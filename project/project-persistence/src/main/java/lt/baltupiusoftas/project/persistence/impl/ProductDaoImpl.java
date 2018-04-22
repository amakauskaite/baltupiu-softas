package lt.baltupiusoftas.project.persistence.impl;

import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.persistence.ProductDao;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Product DAO
 *
 * @author Audrius Tvarijonas
 * & me
 */
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao{

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
        String allProducts = "select p from Product p ";
        return entityManager.createQuery(allProducts, Product.class).getResultList();
    }

    @Override
    public Product findById(long productId) {
        return find(productId);
    }

    @Override
    public int numberOfProducts() {
        String numberOfProducts = "select count(p.id) from Product p";
        return (Integer)entityManager.createNativeQuery(numberOfProducts, Product.class).getSingleResult();
    }
}
