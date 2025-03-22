package com.fastfood.api.application.usecases.customer;

import com.fastfood.api.application.gateways.CustomerGateway;
import com.fastfood.api.domain.entity.customer.Customer;

public class FindCustomerByIdImpl implements FindCustomerByIdUseCase {

    private final CustomerGateway customerGateway;

    public FindCustomerByIdImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerGateway.findCustomerById(id).orElse(null);
    }
}
