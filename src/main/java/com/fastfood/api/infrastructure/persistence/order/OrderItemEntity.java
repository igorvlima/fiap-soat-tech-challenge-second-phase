package com.fastfood.api.infrastructure.persistence.order;

import com.fastfood.api.domain.entity.order.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "order_item")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "order_item_seq_gen", sequenceName = "order_item_id_seq", allocationSize = 1)
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_seq_gen")
    private Long id;
    private Long orderId;
    private Long productId;
    private Long quantity;
    private LocalDateTime createdAt;

    public OrderItemEntity(OrderItem orderItem) {
        this.orderId = orderItem.getOrderId();
        this.productId = orderItem.getProductId();
        this.quantity = orderItem.getQuantity();
        this.createdAt = orderItem.getCreatedAt();
    }

    public OrderItemEntity(Long orderId, Long productId, Long quantity, LocalDateTime now) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.createdAt = now;
    }
}