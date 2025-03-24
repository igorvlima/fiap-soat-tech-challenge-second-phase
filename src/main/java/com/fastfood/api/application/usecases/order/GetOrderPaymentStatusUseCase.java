package com.fastfood.api.application.usecases.order;

import com.fastfood.api.domain.OrderPaymentStatus;

public interface GetOrderPaymentStatusUseCase {
    OrderPaymentStatus getOrderPaymentStatus(Long orderId);
}
