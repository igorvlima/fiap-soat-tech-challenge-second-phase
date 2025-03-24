package com.fastfood.api.infrastructure.persistence.order;

import com.fastfood.api.domain.OrderPaymentStatus;
import com.fastfood.api.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT o FROM OrderEntity o")
    List<OrderEntity> findAllOrders();

    @Query("SELECT o FROM OrderEntity o WHERE o.status = :status")
    List<OrderEntity> findByStatus(@Param("status") OrderStatus status);

    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.status = 'RECEBIDO', o.paymentStatus = 'APPROVED' WHERE o.id = :id")
    void updateApprovedOrderPaymentStatus(@Param("status") OrderPaymentStatus status, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.status = 'CANCELADO', o.paymentStatus = 'REJECTED' WHERE o.id = :id")
    void updateDeclinedOrderPaymentStatus(@Param("status") OrderPaymentStatus status, @Param("id") Long id);

    @Query("SELECT o.paymentStatus FROM OrderEntity o WHERE o.id = :id")
    OrderPaymentStatus getOrderStatusById(@Param("id") Long id);

}
