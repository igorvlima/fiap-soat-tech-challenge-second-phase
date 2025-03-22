package com.fastfood.api.infrastructure.gateways.order;

import com.fastfood.api.domain.entity.order.Order;
import com.fastfood.api.domain.entity.order.OrderItem;
import com.fastfood.api.infrastructure.persistence.order.OrderEntity;
import com.fastfood.api.infrastructure.persistence.order.OrderItemEntity;

import java.util.List;

public class OrderEntityMapper {
    public OrderEntity toOrderEntity(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setCustomerId(order.getCustomerId());
        orderEntity.setTotal(order.getTotal());
        orderEntity.setStatus(order.getStatus());
        orderEntity.setWaitingTimeInMinutes(order.getWaitingTimeInMinutes());
        orderEntity.setCreatedAt(order.getCreatedAt());
        return orderEntity;
    }

    public OrderItemEntity toOrderItemEntity(OrderItem orderItem){return new OrderItemEntity(orderItem);}

    public Order entityToDomainObj(OrderEntity orderEntity, List<OrderItemEntity> orderItemEntities) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setCustomerId(orderEntity.getCustomerId());
        order.setTotal(orderEntity.getTotal());
        order.setStatus(orderEntity.getStatus());
        order.setWaitingTimeInMinutes(orderEntity.getWaitingTimeInMinutes());
        order.setCreatedAt(orderEntity.getCreatedAt());

        List<OrderItemEntity> filteredItems = orderItemEntities.stream()
                .filter(item -> item.getOrderId().equals(orderEntity.getId()))
                .toList();

        order.setItems(filteredItems.stream()
                .map(item -> new OrderItem(item.getId(), item.getOrderId(), item.getProductId(), item.getQuantity(), item.getCreatedAt()))
                .toList());

        return order;
    }

    public List<Order> entityToDomainObjList(List<OrderEntity> jpaOrderEntities, List<OrderItemEntity> jpaOrderItemEntities) {
        return jpaOrderEntities.stream()
                .map(jpaOrderEntity -> entityToDomainObj(jpaOrderEntity, jpaOrderItemEntities))
                .toList();
    }
}
