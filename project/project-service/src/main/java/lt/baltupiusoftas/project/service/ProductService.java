package lt.baltupiusoftas.project.service;

import lt.baltupiusoftas.project.domain.Product;

import java.util.List;

public interface ProductService{
    Product add(Product product);
    Product productById(Long productId);
    List<Product> findAll();
    List<Product> findByCategory(Long categoryId);
    Product update(Product product);
    void deleteProduct(Long productId);
}