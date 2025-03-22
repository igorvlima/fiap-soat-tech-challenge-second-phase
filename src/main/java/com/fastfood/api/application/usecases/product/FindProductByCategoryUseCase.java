package com.fastfood.api.application.usecases.product;

import com.fastfood.api.domain.Category;
import com.fastfood.api.domain.entity.product.Product;

import java.util.List;

public interface FindProductByCategoryUseCase {
    List<Product> findProductByCategory(Category category);
}
