package lt.baltupiusoftas.project.service.Products;

import lt.baltupiusoftas.project.domain.Product;

import java.util.List;

public interface ProductService{
    List<Product> blockOfProducts(int blockSize);
    Product productById(Long productId);
    List<Product> findAll();
}