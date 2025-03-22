package com.fastfood.api.application.usecases.order;

import com.fastfood.api.application.gateways.OrderGateway;
import com.fastfood.api.domain.entity.order.Order;

public class FindOrderByIdImpl implements FindOrderByIdUseCase{

    private final OrderGateway orderGateway;

    public FindOrderByIdImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Order findOrderById(Long id) {
        return orderGateway.findOrderById(id);
    }
}
