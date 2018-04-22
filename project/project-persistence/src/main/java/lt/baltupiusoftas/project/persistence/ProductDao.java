package lt.baltupiusoftas.project.persistence;

import lt.baltupiusoftas.project.domain.Product;

import java.util.List;

/**
 * Product DAO
 *
 * @author Audrius Tvarijonas
 * & me
 */
public interface ProductDao extends GenericDao<Product> {
    List<Product> findBlockOfProducts(int blockSize);
    List<Product> findAllProducts();
    Product findById(long productId);
    int numberOfProducts();
}
