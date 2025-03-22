package com.fastfood.api.infrastructure.gateways.order;

import com.fastfood.api.application.exceptions.OrderNotFoundException;
import com.fastfood.api.application.gateways.OrderGateway;
import com.fastfood.api.domain.OrderStatus;
import com.fastfood.api.domain.entity.order.Order;
import com.fastfood.api.domain.entity.order.OrderItem;
import com.fastfood.api.domain.entity.product.Product;
import com.fastfood.api.infrastructure.persistence.order.OrderItemEntity;
import com.fastfood.api.infrastructure.persistence.order.OrderItemRepository;
import com.fastfood.api.infrastructure.persistence.order.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRespositoryGateway implements OrderGateway {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderEntityMapper mapper;

    public OrderRespositoryGateway(OrderRepository orderRepository, OrderItemRepository orderItemRepository, OrderEntityMapper mapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.mapper = mapper;
    }


    @Override
    public Order createOrder(Order order) {
        var orderEntity = orderRepository.save(mapper.toOrderEntity(order));
        var orderItems = order.getItems().stream()
                .map(orderItem -> new OrderItemEntity(orderEntity.getId(), orderItem.getProductId(), orderItem.getQuantity(), LocalDateTime.now()))
                .toList();

        var orderItemEntity = orderItemRepository.saveAll(orderItems);

        return mapper.entityToDomainObj(orderEntity, orderItemEntity);
    }

    @Override
    public Order updateOrderStatus(Order order) {
        //TODO IMPROVE THIS
        var orderEntity = orderRepository.save(mapper.toOrderEntity(order));
        var orderItemEntity = orderItemRepository.findAllByOrderId(order.getId());
        return mapper.entityToDomainObj(orderEntity, orderItemEntity);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderEntity -> {
                    var orderItemEntities = orderItemRepository.findAllByOrderId(id);
                    return mapper.entityToDomainObj(orderEntity, orderItemEntities);
                })
                .orElseThrow(() -> new OrderNotFoundException("Pedido com ID " + id + " não encontrado."));
    }

    @Override
    public List<Order> findOrderByStatus(OrderStatus status) {
        var orders = orderRepository.findByStatus(status);
        var orderItems = orders.stream()
                .map(order -> orderItemRepository.findAllByOrderId(order.getId()))
                .flatMap(List::stream)
                .toList();
        return mapper.entityToDomainObjList(orders, orderItems);
    }

    @Override
    public OrderStatus getNextOrderStatus(OrderStatus status) {
         OrderStatus[] statuses = OrderStatus.values();
        int currentIndex = status.ordinal();

        if (currentIndex + 1 >= statuses.length) {
            throw new IllegalStateException("Não é possível avançar o status do pedido.");
        }

        return statuses[currentIndex + 1];
    }

    @Override
    public BigDecimal calculateTotalValue(List<Product> productList, List<OrderItem> orderItems) {
        Map<Long, BigDecimal> productPriceMap = productList.stream()
                .collect(Collectors.toMap(Product::getId, Product::getPrice));

        return orderItems.stream()
                .map(item -> {
                    BigDecimal price = productPriceMap.getOrDefault(item.getProductId(), BigDecimal.ZERO);
                    return price.multiply(BigDecimal.valueOf(item.getQuantity()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
