package com.fastfood.api.infrastructure.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
    List<OrderItemEntity> findAllByOrderId(Long orderId);

    @Query("SELECT o FROM OrderItemEntity o WHERE o.orderId IN :orderList")
    List<OrderItemEntity> findAllByOrderList(List<Long> orderList);
}
