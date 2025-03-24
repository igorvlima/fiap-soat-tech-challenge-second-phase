package com.fastfood.api.infrastructure.controller.order;

import com.fastfood.api.application.usecases.order.*;
import com.fastfood.api.domain.OrderPaymentStatus;
import com.fastfood.api.domain.OrderStatus;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final FindOrderByStatusUseCase findOrderByStatusUseCase;
    private final UpdateOrderPaymentUseCase updateOrderPaymentUseCase;
    private final GetOrderPaymentStatusUseCase getOrderPaymentStatusUseCase;
    private final FindAllOrdersUseCase findAllOrdersUseCase;
    private final OrderDTOMapper mapper;


    @Operation(summary = "Create a new order")
    @PostMapping("/order")
    public OrderResponse createOrder(@Valid  @RequestBody CreateOrderRequest createOrderRequest) {
        log.info("Start createOrder for customerId: {}", createOrderRequest.customerId());
        var createdOrder = createOrderUseCase.createOrder(mapper.toOrder(createOrderRequest));
        var response = mapper.toOrderResponse(createdOrder);
        log.info("End createOrder for customerId: {}", createOrderRequest.customerId());
        return response;
    }

    @Operation(summary = "Update order status")
    @PatchMapping("/order/{id}/status")
    public OrderResponse updateOrderStatus(@PathVariable Long id) {
        log.info("Start updateOrderStatus for orderId: {}", id);
        var updatedOrder = updateOrderStatusUseCase.updateOrderStatus(id);
        var response = mapper.toOrderResponse(updatedOrder);
        log.info("End updateOrderStatus for orderId: {}", id);
        return response;
    }

    @Operation(summary = "Find order by ID")
    @GetMapping("/order/{id}")
    public OrderResponse findOrderById(@PathVariable Long id) {
        log.info("Start find orderId: {}", id);
        var order = findOrderByIdUseCase.findOrderById(id);
        var response = mapper.toOrderResponse(order);
        log.info("End find orderId: {}", id);
        return response;
    }

    @Operation(summary = "Find orders by status")
    @GetMapping("/order-status/{status}")
    public List<OrderResponse> findOrderByStatus(@PathVariable OrderStatus status) {
        log.info("Start find order by status: {}", status);
        var orders = findOrderByStatusUseCase.findOrderByStatus(status);
        var response = mapper.toOrderResponseList(orders);
        log.info("End find order by status: {}", status);
        return response;
    }

    @Operation(summary = "Update order payment status")
    @PostMapping("/order/{id}/payment/{status}")
    public void updateOrderPayment(@PathVariable Long id, @PathVariable OrderPaymentStatus status) {
        log.info("Start update payment for orderId: {}", id);
        updateOrderPaymentUseCase.updateOrderPayment(status, id);
        log.info("End update payment for orderId: {}", id);
    }

    @Operation(summary = "Get order payment status")
    @GetMapping("/order/{id}/payment")
    public OrderPaymentStatus getOrderPaymentStatus(@PathVariable Long id) {
        log.info("Start get order payment status for orderId: {}", id);
        var status = getOrderPaymentStatusUseCase.getOrderPaymentStatus(id);
        log.info("End get order payment status for orderId: {}", id);
        return status;
    }

    @Operation(summary = "Find all orders")
    @GetMapping("/order")
    public List<OrderResponse> findAllOrders() {
        log.info("Start findAllOrders");
        var orders = findAllOrdersUseCase.findAllOrders();
        var response = mapper.toOrderResponseList(orders);
        log.info("End findAllOrders");
        return response;
    }
}
