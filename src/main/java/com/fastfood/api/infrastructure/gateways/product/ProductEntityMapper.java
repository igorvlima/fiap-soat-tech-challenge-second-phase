package com.fastfood.api.infrastructure.gateways.product;

import com.fastfood.api.domain.Category;
import com.fastfood.api.domain.ProductImage;
import com.fastfood.api.domain.entity.product.Product;
import com.fastfood.api.infrastructure.persistence.product.ProductEntity;
import com.fastfood.api.infrastructure.persistence.product.ProductImageEntity;

import java.util.List;

public class ProductEntityMapper {
    ProductEntity toEntity(Product product) {
        return new ProductEntity(product);
    }

    public Product entityToDomain(ProductEntity productEntity, List<ProductImageEntity> productImageEntity) {
        if (productEntity == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setPrice(productEntity.getPrice());
        product.setCategory(Category.valueOf(productEntity.getCategory()));
        product.setActive(productEntity.getActive());
        product.setCreatedAt(productEntity.getCreatedAt());
        product.setUpdatedAt(productEntity.getUpdatedAt());

        List<ProductImageEntity> filteredImages = productImageEntity.stream()
                .filter(image -> image.getProductId().equals(productEntity.getId()))
                .toList();

        product.setImages(mapImageEntityToDomainList(filteredImages));
        return product;
    }

    public List<Product> entityToDomainList(List<ProductEntity> products, List<ProductImageEntity> images) {
        return products.stream().map(product -> entityToDomain(product, images)).toList();
    }

    private List<ProductImage> mapImageEntityToDomainList(List<ProductImageEntity> imageEntities) {
        if (imageEntities == null) {
            return null;
        }

        return imageEntities.stream()
                .map(imageEntity -> {
                    ProductImage image = new ProductImage();
                    image.setUrl(imageEntity.getUrl());
                    return image;
                })
                .toList();
    }
}
