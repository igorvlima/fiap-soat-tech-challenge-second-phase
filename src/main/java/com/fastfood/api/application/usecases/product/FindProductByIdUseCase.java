package com.fastfood.api.application.usecases.product;

import com.fastfood.api.domain.entity.product.Product;

public interface FindProductByIdUseCase {
    Product findProductById(Long id);
}
