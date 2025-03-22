package com.fastfood.api.application.usecases.customer;

import com.fastfood.api.application.gateways.CustomerGateway;
import com.fastfood.api.domain.entity.customer.Customer;

public class CreateCustomerImpl implements CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    public CreateCustomerImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerGateway.createCustomer(customer);
    }
}
