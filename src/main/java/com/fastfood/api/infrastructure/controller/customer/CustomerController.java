package com.fastfood.api.infrastructure.controller.customer;

import com.fastfood.api.application.usecases.customer.CreateCustomerUseCase;
import com.fastfood.api.application.usecases.customer.DisableCustomerByIdUseCase;
import com.fastfood.api.application.usecases.customer.FindCustomerByCpfUseCase;
import com.fastfood.api.application.usecases.customer.FindCustomerByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;
    private final DisableCustomerByIdUseCase disableCustomerByIdUseCase;
    private final CustomerDTOMapper mapper;

    @PostMapping("/customer")
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
        var createdCustomer = createCustomerUseCase.createCustomer(mapper.toCustomer(request));
        return mapper.toCustomerResponse(createdCustomer);
    }

    @GetMapping("/customer/{id}")
    public CustomerResponse findCustomerById(@PathVariable Long id) {
        var customer = findCustomerByIdUseCase.findCustomerById(id);
        return mapper.toCustomerResponse(customer);
    }

    @GetMapping("/customer")
    public CustomerResponse findCustomerByCpf(@RequestParam String cpf) {
        var customer = findCustomerByCpfUseCase.findCustomerByCpf(cpf);
        return mapper.toCustomerResponse(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void disableCustomerById(@PathVariable Long id) {
        disableCustomerByIdUseCase.disableCustomerById(id);
    }
}
