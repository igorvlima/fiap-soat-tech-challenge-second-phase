package com.fastfood.api.application.usecases.product;

import com.fastfood.api.application.gateways.ProductGateway;

public class DisableProductByIdImpl implements DisableProductByIdUseCase {

    private final ProductGateway productGateway;

    public DisableProductByIdImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public void disableProductById(Long id) {
        productGateway.disableProductById(id);
    }
}
