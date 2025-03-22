package com.fastfood.api.application.usecases.customer;

import com.fastfood.api.application.gateways.CustomerGateway;
import com.fastfood.api.domain.entity.customer.Customer;

public class FindCustomerByCpfImpl implements FindCustomerByCpfUseCase {

    private final CustomerGateway customerGateway;

    public FindCustomerByCpfImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Customer findCustomerByCpf(String cpf) {
        return customerGateway.findCustomerByCpf(cpf).orElse(null);
    }
}
