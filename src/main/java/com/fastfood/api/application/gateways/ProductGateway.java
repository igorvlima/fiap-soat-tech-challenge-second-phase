package com.fastfood.api.application.gateways;

import com.fastfood.api.domain.Category;
import com.fastfood.api.domain.entity.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductGateway {
    Product createProduct(Product product);
    Optional<Product> findProductById(Long id);
    List<Product> findProductByCategory(Category category);
    Product updateProduct(Long id, Product product);
    void disableProductById(Long id);
}
