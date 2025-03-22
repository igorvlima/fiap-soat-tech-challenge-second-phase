package com.fastfood.api.application.usecases.product;

import com.fastfood.api.application.gateways.ProductGateway;
import com.fastfood.api.domain.Category;
import com.fastfood.api.domain.entity.product.Product;

import java.util.List;

public class FindProductByCategoryImpl implements FindProductByCategoryUseCase {

    private final ProductGateway productGateway;

    public FindProductByCategoryImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<Product> findProductByCategory(Category category) {
        return productGateway.findProductByCategory(category);
    }
}
