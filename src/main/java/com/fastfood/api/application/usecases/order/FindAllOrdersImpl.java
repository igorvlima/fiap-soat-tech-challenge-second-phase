package com.fastfood.api.application.usecases.order;

import com.fastfood.api.application.gateways.OrderGateway;
import com.fastfood.api.domain.entity.order.Order;

import java.util.List;

public class FindAllOrdersImpl implements FindAllOrdersUseCase{

    private final OrderGateway orderGateway;

    public FindAllOrdersImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderGateway.findAllOrders();
    }
}
