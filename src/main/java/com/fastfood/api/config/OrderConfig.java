package com.fastfood.api.config;

import com.fastfood.api.application.gateways.OrderGateway;
import com.fastfood.api.application.gateways.ProductGateway;
import com.fastfood.api.application.usecases.order.*;
import com.fastfood.api.infrastructure.controller.order.OrderDTOMapper;
import com.fastfood.api.infrastructure.gateways.order.OrderEntityMapper;
import com.fastfood.api.infrastructure.gateways.order.OrderRespositoryGateway;
import com.fastfood.api.infrastructure.persistence.order.OrderItemRepository;
import com.fastfood.api.infrastructure.persistence.order.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    UpdateOrderStatusImpl updateOrderStatusImpl(OrderGateway orderGateway) {
        return new UpdateOrderStatusImpl(orderGateway);
    }

    @Bean
    FindOrderByStatusImpl findOrderByStatusImpl(OrderGateway orderGateway) {
        return new FindOrderByStatusImpl(orderGateway);
    }

    @Bean
    FindOrderByIdImpl findOrderByIdImpl(OrderGateway orderGateway) {
        return new FindOrderByIdImpl(orderGateway);
    }

    @Bean
    CreateOrderImpl createOrderImpl(OrderGateway orderGateway, ProductGateway productGateway) {
        return new CreateOrderImpl(orderGateway, productGateway);
    }

    @Bean
    GetOrderPaymentStatusImpl getOrderPaymentStatusImpl(OrderGateway orderGateway) {
        return new GetOrderPaymentStatusImpl(orderGateway);
    }

    @Bean
    UpdateOrderPaymentImpl updateOrderPaymentImpl(OrderGateway orderGateway) {
        return new UpdateOrderPaymentImpl(orderGateway);
    }

    @Bean
    FindAllOrdersImpl findAllOrdersImpl(OrderGateway orderGateway) {
        return new FindAllOrdersImpl(orderGateway);
    }

    @Bean
    OrderGateway orderGateway(OrderRepository orderRepository, OrderItemRepository orderItemRepository, OrderEntityMapper orderEntityMapper) {
        return new OrderRespositoryGateway(orderRepository, orderItemRepository, orderEntityMapper);
    }

    @Bean
    OrderEntityMapper orderEntityMapper() {
        return new OrderEntityMapper();
    }

    @Bean
    OrderDTOMapper orderDTOMapper() {
        return new OrderDTOMapper();
    }
}
