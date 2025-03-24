package com.fastfood.api.infrastructure.controller.order;

import com.fastfood.api.domain.OrderPaymentStatus;
import com.fastfood.api.domain.OrderPaymentType;
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

        OrderPaymentStatus paymentStatus,
        OrderPaymentType paymentType,
        List<OrderItemResponse> items,
        LocalDateTime createdAt
) {
}
