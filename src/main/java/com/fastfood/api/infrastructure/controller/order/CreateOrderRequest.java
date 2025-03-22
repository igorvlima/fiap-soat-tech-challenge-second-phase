package com.fastfood.api.infrastructure.controller.order;

import java.util.List;

public record CreateOrderRequest(
        Long customerId,
        Long waitingTimeInMinutes,
        List<CreateOrderItemRequest> items
) {
}
