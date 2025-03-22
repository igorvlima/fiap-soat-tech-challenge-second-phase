package com.fastfood.api.application.usecases.order;

import com.fastfood.api.domain.entity.order.Order;

public interface UpdateOrderStatusUseCase {
    Order updateOrderStatus(Long id);
}
