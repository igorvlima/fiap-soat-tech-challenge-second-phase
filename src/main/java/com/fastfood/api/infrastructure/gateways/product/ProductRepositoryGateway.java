package com.fastfood.api.infrastructure.gateways.product;

import com.fastfood.api.application.exceptions.ProductNotFoundException;
import com.fastfood.api.application.gateways.ProductGateway;
import com.fastfood.api.domain.Category;
import com.fastfood.api.domain.entity.product.Product;
import com.fastfood.api.infrastructure.persistence.product.ProductEntity;
import com.fastfood.api.infrastructure.persistence.product.ProductImageEntity;
import com.fastfood.api.infrastructure.persistence.product.ProductImageRepository;
import com.fastfood.api.infrastructure.persistence.product.ProductRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryGateway implements ProductGateway {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductEntityMapper mapper;

    public ProductRepositoryGateway(ProductRepository productRepository, ProductImageRepository productImageRepository, ProductEntityMapper mapper) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
        this.mapper = mapper;
    }

    @Override
    public Product createProduct(Product product) {
        product.setActive(true);
        product.setCreatedAt(LocalDateTime.now());
        var productEntity = productRepository.save(new ProductEntity(product));

        var productImageEntities = product.getImages().stream()
                .map(image -> new ProductImageEntity(productEntity.getId(), image.getUrl(), LocalDateTime.now(), null))
                .toList();

        var images = productImageRepository.saveAll(productImageEntities);

        return mapper.entityToDomain(productEntity, images);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Produto com ID " + id + " não encontrado"));
        List<ProductImageEntity> productImageEntities = productImageRepository.findByProductId(id);
        return Optional.of(mapper.entityToDomain(productEntity, productImageEntities));
    }

    @Override
    public List<Product> findProductByCategory(Category category) {
        List<ProductEntity> products = productRepository.findProductByCategory(category.toString());
        List<ProductImageEntity> images = productImageRepository.findAll();
        return mapper.entityToDomainList(products, images);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        var currentProduct = productRepository.findById(id).orElseThrow();

        currentProduct.setId(currentProduct.getId());
        currentProduct.setActive(currentProduct.getActive());
        currentProduct.setCategory(product.getCategory().toString());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setName(product.getName());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setCreatedAt(currentProduct.getCreatedAt());
        currentProduct.setUpdatedAt(LocalDateTime.now());

        productImageRepository.deleteAllImagesByProductId(id);

        List<ProductImageEntity> newImages = new ArrayList<>();
        if (product.getImages() != null) {
            newImages = product.getImages().stream()
                    .map(image -> new ProductImageEntity(currentProduct.getId(), image.getUrl(), LocalDateTime.now(), LocalDateTime.now()))
                    .toList();
        }

        var updatedEntity = productRepository.save(currentProduct);
        var images = productImageRepository.saveAll(newImages);

        return mapper.entityToDomain(updatedEntity, images);
    }

    @Override
    public void disableProductById(Long id) {
        productRepository.disableProductById(id);
    }
}
