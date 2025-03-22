package com.fastfood.api.infrastructure.persistence.order;

import com.fastfood.api.domain.OrderStatus;
import com.fastfood.api.domain.entity.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "\"order\"")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "order_seq_gen", sequenceName = "order_id_seq", allocationSize = 1)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
    private Long id;
    private Long customerId;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Long waitingTimeInMinutes;
    private LocalDateTime createdAt;

    public OrderEntity(Order order) {
        this.customerId = order.getCustomerId();
        this.total = order.getTotal();
        this.status = order.getStatus();
        this.waitingTimeInMinutes = order.getWaitingTimeInMinutes();
        this.createdAt = order.getCreatedAt();
    }
}