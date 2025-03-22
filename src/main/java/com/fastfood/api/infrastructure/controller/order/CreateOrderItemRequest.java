package com.fastfood.api.infrastructure.controller.order;

public record CreateOrderItemRequest(
        Long productId,
        Long quantity
) {
}
