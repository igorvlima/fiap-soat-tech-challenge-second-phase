package com.fastfood.api.application.usecases.customer;

import com.fastfood.api.application.gateways.CustomerGateway;

public class DisableCustomerByIdByIdImpl implements DisableCustomerByIdUseCase {

    private final CustomerGateway customerGateway;

    public DisableCustomerByIdByIdImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public void disableCustomerById(Long id) {
        customerGateway.disableCustomerById(id);
    }
}
