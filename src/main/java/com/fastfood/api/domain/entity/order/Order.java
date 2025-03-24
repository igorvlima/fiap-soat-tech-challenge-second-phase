package com.fastfood.api.domain.entity.order;

import com.fastfood.api.domain.OrderPaymentStatus;
import com.fastfood.api.domain.OrderPaymentType;
import com.fastfood.api.domain.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private Long customerId;
    private BigDecimal total;
    private OrderStatus status;
    private OrderPaymentStatus paymentStatus;
    private OrderPaymentType paymentType;
    private String paymentQrCode;
    private Long waitingTimeInMinutes;
    private List<OrderItem> items;
    private LocalDateTime createdAt;

    public Order() {
    }
    public Order(Long id, Long customerId, BigDecimal total, OrderStatus status, Long waitingTimeInMinutes, List<OrderItem> items,
                 OrderPaymentStatus orderPaymentStatus, OrderPaymentType paymentType, String paymentQrCode, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.status = status;
        this.paymentStatus = orderPaymentStatus;
        this.paymentType = paymentType;
        this.paymentQrCode = paymentQrCode;
        this.waitingTimeInMinutes = waitingTimeInMinutes;
        this.items = items;
        this.createdAt = createdAt;
    }

    public Order(Long customerId, Long waitingTimeInMinutes, OrderPaymentType paymentType, List<OrderItem> items){
        this.customerId = customerId;
        this.paymentType = paymentType;
        this.waitingTimeInMinutes = waitingTimeInMinutes;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderPaymentStatus getPaymentStatus() {return paymentStatus;}

    public void setPaymentStatus(OrderPaymentStatus paymentStatus) {this.paymentStatus = paymentStatus;}

    public OrderPaymentType getPaymentType() {return paymentType;}

    public void setPaymentType(OrderPaymentType paymentType) {this.paymentType = paymentType;}

    public String getPaymentQrCode() {
        return paymentQrCode;
    }

    public void setPaymentQrCode(String paymentQrCode) {
        this.paymentQrCode = paymentQrCode;
    }

    public Long getWaitingTimeInMinutes() {
        return waitingTimeInMinutes;
    }

    public void setWaitingTimeInMinutes(Long waitingTime) {
        this.waitingTimeInMinutes = waitingTime;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}