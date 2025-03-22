package com.fastfood.api.config;

import com.fastfood.api.application.gateways.ProductGateway;
import com.fastfood.api.application.usecases.product.*;
import com.fastfood.api.infrastructure.controller.product.ProductDTOMapper;
import com.fastfood.api.infrastructure.gateways.product.ProductEntityMapper;
import com.fastfood.api.infrastructure.gateways.product.ProductRepositoryGateway;
import com.fastfood.api.infrastructure.persistence.product.ProductImageRepository;
import com.fastfood.api.infrastructure.persistence.product.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    CreateProductImpl createProductUseCase(ProductGateway productGateway, ProductDTOMapper mapper) {
        return new CreateProductImpl(productGateway);
    }

    @Bean
    FindProductByIdImpl findProductByIdUseCase(ProductGateway productGateway) {
        return new FindProductByIdImpl(productGateway);
    }

    @Bean
    FindProductByCategoryImpl findProductByCategoryUseCase(ProductGateway productGateway) {
        return new FindProductByCategoryImpl(productGateway);
    }

    @Bean
    UpdateProductImpl updateProductUseCase(ProductGateway productGateway) {
        return new UpdateProductImpl(productGateway);
    }

    @Bean
    DisableProductByIdImpl disableProductByIdUseCase(ProductGateway productGateway) {
        return new DisableProductByIdImpl(productGateway);
    }

    @Bean
    ProductGateway productGateway(ProductRepository productRepository, ProductImageRepository productImageRepository,
                                  ProductEntityMapper mapper) {
        return new ProductRepositoryGateway(productRepository, productImageRepository, mapper);
    }

    @Bean
    ProductEntityMapper productEntityMapper() {
        return new ProductEntityMapper();
    }

    @Bean
    ProductDTOMapper productDTOMapper() {
        return new ProductDTOMapper();
    }

}
