package com.fastfood.api.infrastructure.controller.order;

import jakarta.validation.constraints.NotNull;

public record CreateOrderItemRequest(
        @NotNull
        Long productId,
        @NotNull
        Long quantity
) {
}
