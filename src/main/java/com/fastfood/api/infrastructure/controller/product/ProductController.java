package com.fastfood.api.infrastructure.controller.product;

import com.fastfood.api.application.usecases.product.*;
import com.fastfood.api.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;
    private final FindProductByCategoryUseCase findProductByCategoryUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DisableProductByIdUseCase disableProductByIdUseCase;

    private final ProductDTOMapper mapper;

    @PostMapping("/product")
    public ProductResponse createProduct(@RequestBody ProductRequest request) {

        var createdProduct = createProductUseCase.createProduct(mapper.toProduct(request));
        return mapper.toProductResponse(createdProduct);
    }

    @GetMapping("/product/{id}")
    public ProductResponse findProductById(@PathVariable Long id) {

        var product = findProductByIdUseCase.findProductById(id);

        return mapper.toProductResponse(product);
    }

    @GetMapping("/product")
    public List<ProductResponse> findProductByCategory(@RequestParam Category category) {
        var products = findProductByCategoryUseCase.findProductByCategory(category);
        return mapper.toProductResponseList(products);
    }

    @PatchMapping("/product/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        var updatedProduct = updateProductUseCase.updateProduct(id, mapper.toProduct(request));
        return mapper.toProductResponse(updatedProduct);
    }

    @DeleteMapping("/product/{id}")
    public void disableProductById(@PathVariable Long id) {
        disableProductByIdUseCase.disableProductById(id);
    }
}
