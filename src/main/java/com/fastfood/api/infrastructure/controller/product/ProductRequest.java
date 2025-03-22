package com.fastfood.api.infrastructure.controller.product;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequest(
        String name,
        BigDecimal price,
        String description,
        String category,
        boolean active,
        List<ProductImageRequest> images
) {
}
