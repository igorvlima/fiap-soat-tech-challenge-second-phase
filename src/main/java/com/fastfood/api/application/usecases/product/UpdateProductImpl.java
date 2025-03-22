package com.fastfood.api.application.usecases.product;

import com.fastfood.api.application.gateways.ProductGateway;
import com.fastfood.api.domain.entity.product.Product;

public class UpdateProductImpl implements UpdateProductUseCase{

    private final ProductGateway productGateway;

    public UpdateProductImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productGateway.updateProduct(id, product);
    }
}
