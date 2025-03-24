package com.fastfood.api.infrastructure.controller.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequest(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @Positive
        BigDecimal price,

        @NotNull
        @NotBlank
        String description,

        @NotNull
        @NotBlank
        String category,
        boolean active,
        List<ProductImageRequest> images
) {
}
