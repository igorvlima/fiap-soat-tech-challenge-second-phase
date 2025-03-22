package com.fastfood.api.infrastructure.controller.customer;

import com.fastfood.api.domain.entity.customer.Customer;
public class CustomerDTOMapper {

    CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getCpf(), customer.getName(), customer.getEmail(),
                customer.getActive(), customer.getCreatedAt(), customer.getUpdatedAt());
    }

    Customer toCustomer(CreateCustomerRequest request) {
        return new Customer(request.cpf(), request.name(), request.email());
    }
}
