package com.fastfood.api.infrastructure.controller.order;

import java.time.LocalDateTime;

public record OrderItemResponse(
        Long id,
        Long orderId,
        Long productId,
        Long quantity,
        LocalDateTime createdAt
) {
}
