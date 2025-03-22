package com.fastfood.api.infrastructure.controller.order;

import com.fastfood.api.domain.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        Long customerId,
        BigDecimal total,
        OrderStatus status,
        Long waitingTimeInMinutes,
        List<OrderItemResponse> items,
        LocalDateTime createdAt
) {
}
