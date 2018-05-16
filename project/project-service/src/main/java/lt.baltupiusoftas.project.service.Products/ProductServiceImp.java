package lt.baltupiusoftas.project.service.Products;

import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.persistence.ProductDao;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceImp implements ProductService {
    @Inject
    private ProductDao productDao;

    @Override
    public List<Product> blockOfProducts(int blockSize) {
        //not yet implemented
        return null;
    }

    @Override
    public Product productById(Long productId) {
        return productDao.findById(productId);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAllProducts();
    }
}
