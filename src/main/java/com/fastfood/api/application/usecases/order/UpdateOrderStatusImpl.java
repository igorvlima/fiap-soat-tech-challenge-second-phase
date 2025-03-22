package com.fastfood.api.application.usecases.order;

import com.fastfood.api.application.gateways.OrderGateway;
import com.fastfood.api.domain.OrderStatus;
import com.fastfood.api.domain.entity.order.Order;

public class UpdateOrderStatusImpl implements UpdateOrderStatusUseCase {

    private final OrderGateway orderGateway;

    public UpdateOrderStatusImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Order updateOrderStatus(Long id) {
        var order = orderGateway.findOrderById(id);

        if (order.getStatus() == OrderStatus.FINALIZADO) {
            throw new IllegalStateException("O pedido já está finalizado e não pode ser atualizado novamente.");
        }

        OrderStatus nextStatus = orderGateway.getNextOrderStatus(order.getStatus());

        order.setStatus(nextStatus);

        return orderGateway.updateOrderStatus(order);
    }
}
