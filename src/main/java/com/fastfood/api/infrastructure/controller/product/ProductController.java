package com.fastfood.api.infrastructure.controller.product;

import com.fastfood.api.application.usecases.product.*;
import com.fastfood.api.domain.Category;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;
    private final FindProductByCategoryUseCase findProductByCategoryUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DisableProductByIdUseCase disableProductByIdUseCase;

    private final ProductDTOMapper mapper;

    @Operation(summary = "Create a new product")
    @PostMapping("/product")
    public ProductResponse createProduct(@Valid @RequestBody ProductRequest request) {
        log.info("Start createProduct for name: {}", request.name());
        var createdProduct = createProductUseCase.createProduct(mapper.toProduct(request));
        log.info("product created with name: {}", request.name());
        return mapper.toProductResponse(createdProduct);
    }

    @Operation(summary = "Find product by ID")
    @GetMapping("/product/{id}")
    public ProductResponse findProductById(@PathVariable Long id) {
        log.info("Start to find product with id: {}", id);
        var product = findProductByIdUseCase.findProductById(id);
        log.info("product found with id: {}", id);
        return mapper.toProductResponse(product);
    }

    @Operation(summary = "Find product by category")
    @GetMapping("/product")
    public List<ProductResponse> findProductByCategory(@RequestParam Category category) {
        log.info("Start to find product by category: {}", category);
        var products = findProductByCategoryUseCase.findProductByCategory(category);
        log.info("products found by category: {}", category);
        return mapper.toProductResponseList(products);
    }

    @Operation(summary = "Update product")
    @PatchMapping("/product/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        log.info("Start updateProduct for id: {}", id);
        var updatedProduct = updateProductUseCase.updateProduct(id, mapper.toProduct(request));
        log.info("product updated with id: {}", id);
        return mapper.toProductResponse(updatedProduct);
    }

    @Operation(summary = "Disable product by ID")
    @DeleteMapping("/product/{id}")
    public void disableProductById(@PathVariable Long id) {
        log.info("Start to disable product with id: {}", id);
        disableProductByIdUseCase.disableProductById(id);
        log.info("product disabled with id: {}", id);
    }
}
