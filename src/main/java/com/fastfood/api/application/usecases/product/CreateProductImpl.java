package com.fastfood.api.application.usecases.product;

import com.fastfood.api.application.gateways.ProductGateway;
import com.fastfood.api.domain.entity.product.Product;

public class CreateProductImpl implements CreateProductUseCase {

    private final ProductGateway productGateway;

    public CreateProductImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product createProduct(Product product) {
        return productGateway.createProduct(product);
    }
}
