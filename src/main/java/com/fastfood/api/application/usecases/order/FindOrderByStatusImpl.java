package com.fastfood.api.application.usecases.order;

import com.fastfood.api.application.gateways.OrderGateway;
import com.fastfood.api.domain.OrderStatus;
import com.fastfood.api.domain.entity.order.Order;

import java.util.List;

public class FindOrderByStatusImpl implements FindOrderByStatusUseCase{
    private final OrderGateway orderGateway;

    public FindOrderByStatusImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public List<Order> findOrderByStatus(OrderStatus status) {
        return orderGateway.findOrderByStatus(status);
    }
}
