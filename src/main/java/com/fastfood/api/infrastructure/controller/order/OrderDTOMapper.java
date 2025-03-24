package com.fastfood.api.infrastructure.controller.order;

import com.fastfood.api.domain.entity.order.Order;
import com.fastfood.api.domain.entity.order.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDTOMapper {
    public OrderResponse toOrderResponse (Order order){
        return new OrderResponse(
                order.getId(),
                order.getCustomerId(),
                order.getTotal(),
                order.getStatus(),
                order.getWaitingTimeInMinutes(),
                order.getPaymentStatus(),
                order.getPaymentType(),
                order.getItems().stream()
                        .map(item -> new OrderItemResponse(item.getId(), item.getOrderId(), item.getProductId(), item.getQuantity(), item.getCreatedAt()))
                        .collect(Collectors.toList()),
                order.getCreatedAt()
        );
    }

    List<OrderResponse> toOrderResponseList(List<Order> orderResponses) {
        return orderResponses.stream()
                .map(this::toOrderResponse)
                .collect(Collectors.toList());
    }

    Order toOrder(CreateOrderRequest request){
        return new Order(
                request.customerId(),
                request.waitingTimeInMinutes(),
                request.paymentType(),
                request.items().stream()
                        .map(item -> new OrderItem(item.productId(), item.quantity()))
                        .collect(Collectors.toList())
        );
    }

}
