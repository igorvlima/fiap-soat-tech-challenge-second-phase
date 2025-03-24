package com.fastfood.api.application.gateways;

import com.fastfood.api.domain.OrderPaymentStatus;
import com.fastfood.api.domain.OrderStatus;
import com.fastfood.api.domain.entity.order.Order;
import com.fastfood.api.domain.entity.order.OrderItem;
import com.fastfood.api.domain.entity.product.Product;

import java.math.BigDecimal;
import java.util.List;

public interface OrderGateway {
    Order createOrder(Order order);
    List<Order> findAllOrders();
    Order updateOrderStatus(Order order);
    Order findOrderById(Long id);
    List<Order> findOrderByStatus(OrderStatus status);
    OrderStatus getNextOrderStatus(OrderStatus status);
    BigDecimal calculateTotalValue(List<Product> productList, List<OrderItem> orderItems);
    void updateOrderPayment(OrderPaymentStatus paymentStatus, Long orderId);
    OrderPaymentStatus getOrderPaymentStatus(Long orderId);
    int getOrderStatusPriority(OrderStatus status);
}
