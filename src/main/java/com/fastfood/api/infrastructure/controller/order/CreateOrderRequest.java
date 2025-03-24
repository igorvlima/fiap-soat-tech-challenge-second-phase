package com.fastfood.api.infrastructure.controller.order;

import com.fastfood.api.domain.OrderPaymentType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateOrderRequest(
        Long customerId,

        @NotNull
        @Positive
        Long waitingTimeInMinutes,

        @NotNull
        OrderPaymentType paymentType,
        @NotNull
        List<CreateOrderItemRequest> items
) {
}
