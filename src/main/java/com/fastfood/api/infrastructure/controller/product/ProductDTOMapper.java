package com.fastfood.api.infrastructure.controller.product;

import com.fastfood.api.domain.ProductImage;
import com.fastfood.api.domain.entity.product.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDTOMapper {

    ProductResponse toProductResponse(Product product) {
        List<ProductImageResponse> imageResponses = product.getImages().stream()
                .map(image -> new ProductImageResponse(image.getUrl()))
                .collect(Collectors.toList());
        return new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDescription(),
                product.getCategory(), product.getActive(), imageResponses, product.getCreatedAt(), product.getUpdatedAt());
    }
    List<ProductResponse> toProductResponseList(List<Product> products) {
        return products.stream()
                .map(this::toProductResponse)
                .collect(Collectors.toList());
    }

    Product toProduct(ProductRequest createProductRequest) {
        List<ProductImage> images = createProductRequest.images().stream()
                .map(imageRequest -> new ProductImage(imageRequest.url()))
                .collect(Collectors.toList());
        return new Product(createProductRequest.name(), createProductRequest.price(), createProductRequest.description(),
                createProductRequest.category(), createProductRequest.active(), images);
    }

}
