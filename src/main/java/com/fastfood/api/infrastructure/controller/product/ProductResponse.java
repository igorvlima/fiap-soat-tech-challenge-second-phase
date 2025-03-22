package com.fastfood.api.infrastructure.controller.product;

import com.fastfood.api.domain.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        String description,
        Category category,
        Boolean active,
        List<ProductImageResponse> images,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
