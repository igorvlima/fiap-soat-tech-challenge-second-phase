package com.fastfood.api.application.usecases.order;

import com.fastfood.api.domain.OrderPaymentStatus;

public interface UpdateOrderPaymentUseCase {
    void updateOrderPayment(OrderPaymentStatus paymentStatus, Long orderId);
}
