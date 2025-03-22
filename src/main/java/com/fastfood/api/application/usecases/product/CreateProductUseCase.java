package com.fastfood.api.application.usecases.product;

import com.fastfood.api.domain.entity.product.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
