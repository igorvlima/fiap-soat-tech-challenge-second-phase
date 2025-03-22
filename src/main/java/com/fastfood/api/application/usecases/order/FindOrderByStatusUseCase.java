package com.fastfood.api.application.usecases.order;

import com.fastfood.api.domain.OrderStatus;
import com.fastfood.api.domain.entity.order.Order;

import java.util.List;

public interface FindOrderByStatusUseCase {
    List<Order> findOrderByStatus(OrderStatus status);
}
