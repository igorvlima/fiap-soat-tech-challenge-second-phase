package com.fastfood.api.application.usecases.order;

import com.fastfood.api.application.gateways.OrderGateway;
import com.fastfood.api.domain.OrderPaymentStatus;

public class UpdateOrderPaymentImpl implements UpdateOrderPaymentUseCase {

    private final OrderGateway orderGateway;

    public UpdateOrderPaymentImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public void updateOrderPayment(OrderPaymentStatus paymentStatus, Long orderId) {
        orderGateway.updateOrderPayment(paymentStatus, orderId);
    }
}
