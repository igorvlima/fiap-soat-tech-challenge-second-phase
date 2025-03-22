package com.fastfood.api.application.usecases.order;

import com.fastfood.api.domain.entity.order.Order;

public interface CreateOrderUseCase {
    Order createOrder(Order order);
}
