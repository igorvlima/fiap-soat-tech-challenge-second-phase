package com.fastfood.api.application.usecases.order;

import com.fastfood.api.application.gateways.OrderGateway;
import com.fastfood.api.domain.OrderPaymentStatus;

public class GetOrderPaymentStatusImpl implements GetOrderPaymentStatusUseCase{

    private final OrderGateway orderGateway;

    public GetOrderPaymentStatusImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public OrderPaymentStatus getOrderPaymentStatus(Long orderId) {
        return orderGateway.getOrderPaymentStatus(orderId);
    }
}
