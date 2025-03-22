package com.fastfood.api.application.gateways;

import com.fastfood.api.domain.entity.customer.Customer;

import java.util.Optional;

public interface CustomerGateway {
    Customer createCustomer(Customer customer);
    Optional<Customer> findCustomerById(Long id);
    Optional<Customer> findCustomerByCpf(String cpf);
    void disableCustomerById(Long id);
}
