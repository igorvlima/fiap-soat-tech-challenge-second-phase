package com.fastfood.api.infrastructure.controller.customer;

import com.fastfood.api.application.usecases.customer.CreateCustomerUseCase;
import com.fastfood.api.application.usecases.customer.DisableCustomerByIdUseCase;
import com.fastfood.api.application.usecases.customer.FindCustomerByCpfUseCase;
import com.fastfood.api.application.usecases.customer.FindCustomerByIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;
    private final DisableCustomerByIdUseCase disableCustomerByIdUseCase;
    private final CustomerDTOMapper mapper;

    @Operation(summary = "Create a new customer")
    @PostMapping("/customer")
    public CustomerResponse createCustomer(@RequestBody @Valid CreateCustomerRequest request) {
        log.info("Start createCustomer for email: {}", request.email());
        var createdCustomer = createCustomerUseCase.createCustomer(mapper.toCustomer(request));
        log.info("customer created with email: {}", request.email());
        return mapper.toCustomerResponse(createdCustomer);
    }

    @Operation(summary = "Find customer by ID")
    @GetMapping("/customer/{id}")
    public CustomerResponse findCustomerById(@PathVariable Long id) {
        log.info("Start to find customer with id: {}", id);
        var customer = findCustomerByIdUseCase.findCustomerById(id);
        log.info("customer found with id: {}", id);
        return mapper.toCustomerResponse(customer);
    }

    @Operation(summary = "Find customer by CPF")
    @GetMapping("/customer")
    public CustomerResponse findCustomerByCpf(@RequestParam String cpf) {
        log.info("Start to find customer with cpf: {}", cpf);
        var customer = findCustomerByCpfUseCase.findCustomerByCpf(cpf);
        log.info("customer found with cpf: {}", cpf);
        return mapper.toCustomerResponse(customer);
    }

    @Operation(summary = "Disable customer by ID")
    @DeleteMapping("/customer/{id}")
    public void disableCustomerById(@PathVariable Long id) {
        log.info("Start to disable customer with id: {}", id);
        disableCustomerByIdUseCase.disableCustomerById(id);
        log.info("customer disabled with id: {}", id);
    }
}
