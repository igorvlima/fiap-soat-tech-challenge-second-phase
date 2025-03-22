package com.fastfood.api.application.usecases.product;

import com.fastfood.api.application.gateways.ProductGateway;
import com.fastfood.api.domain.entity.product.Product;

public class FindProductByIdImpl implements FindProductByIdUseCase {

    private final ProductGateway productGateway;

    public FindProductByIdImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product findProductById(Long id) {
        return productGateway.findProductById(id).orElse(null);
    }
}
