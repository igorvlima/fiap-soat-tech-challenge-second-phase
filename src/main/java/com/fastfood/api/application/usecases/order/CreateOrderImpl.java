package com.fastfood.api.application.usecases.order;

import com.fastfood.api.application.exceptions.NoItemsFoundException;
import com.fastfood.api.application.gateways.OrderGateway;
import com.fastfood.api.application.gateways.ProductGateway;
import com.fastfood.api.domain.OrderStatus;
import com.fastfood.api.domain.entity.order.Order;
import com.fastfood.api.domain.entity.order.OrderItem;
import com.fastfood.api.domain.entity.product.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CreateOrderImpl implements CreateOrderUseCase{
    private final OrderGateway orderGateway;
    private final ProductGateway productGateway;

    public CreateOrderImpl(OrderGateway orderGateway, ProductGateway productGateway) {
        this.orderGateway = orderGateway;
        this.productGateway = productGateway;
    }

    @Override
    public Order createOrder(Order order) {

        List<Product> products = order.getItems().stream()
                .map(OrderItem::getProductId)
                .map(id -> productGateway.findProductById(id)
                        .orElseThrow(() -> new NoItemsFoundException(
                                "Item com ID " + id + " não encontrado, não foi possível fechar o pedido.")))
                .toList();

        order.setTotal(orderGateway.calculateTotalValue(products, order.getItems()));
        order.setCreatedAt(LocalDateTime.now());
        order.getItems().forEach(item -> item.setCreatedAt(LocalDateTime.now()));
        order.setStatus(OrderStatus.RECEBIDO);

        return orderGateway.createOrder(order);
    }
}
