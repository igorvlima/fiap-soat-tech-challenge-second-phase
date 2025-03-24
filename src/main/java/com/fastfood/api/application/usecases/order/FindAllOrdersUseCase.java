package com.fastfood.api.application.usecases.order;

import com.fastfood.api.domain.entity.order.Order;

import java.util.List;

public interface FindAllOrdersUseCase {
    List<Order> findAllOrders();
}
