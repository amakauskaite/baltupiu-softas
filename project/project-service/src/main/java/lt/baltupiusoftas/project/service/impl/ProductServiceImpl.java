package lt.baltupiusoftas.project.service.impl;

import lt.baltupiusoftas.project.domain.Product;
import lt.baltupiusoftas.project.persistence.ProductDao;
import lt.baltupiusoftas.project.service.ProductService;

import javax.inject.Inject;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductDao productDao;

    @Override
    public Product productById(Long productId) {
        return productDao.find(productId);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAllProducts();
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        return productDao.findByCategory(categoryId);
    }
}
