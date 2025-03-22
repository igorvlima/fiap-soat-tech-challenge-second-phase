package com.fastfood.api.infrastructure.controller.order;

import com.fastfood.api.application.usecases.order.CreateOrderUseCase;
import com.fastfood.api.application.usecases.order.FindOrderByIdUseCase;
import com.fastfood.api.application.usecases.order.FindOrderByStatusUseCase;
import com.fastfood.api.application.usecases.order.UpdateOrderStatusUseCase;
import com.fastfood.api.domain.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;
    private final FindOrderByStatusUseCase findOrderByStatusUseCase;
    private final OrderDTOMapper mapper;


    @PostMapping("/order")
    public OrderResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        var createdOrder = createOrderUseCase.createOrder(mapper.toOrder(createOrderRequest));
        return mapper.toOrderResponse(createdOrder);
    }

    @PatchMapping("/order-status/{id}")
    public OrderResponse updateOrderStatus(@PathVariable Long id){
        var updatedOrder = updateOrderStatusUseCase.updateOrderStatus(id);
        return mapper.toOrderResponse(updatedOrder);
    }

    @GetMapping("/order/{id}")
    public OrderResponse findOrderById(@PathVariable Long id){
        var order = findOrderByIdUseCase.findOrderById(id);
        return mapper.toOrderResponse(order);
    }

    @GetMapping("/order-status/{status}")
    public List<OrderResponse> findOrderByStatus(@PathVariable OrderStatus status){
        var orders = findOrderByStatusUseCase.findOrderByStatus(status);
        return mapper.toOrderResponseList(orders);
    }

}
