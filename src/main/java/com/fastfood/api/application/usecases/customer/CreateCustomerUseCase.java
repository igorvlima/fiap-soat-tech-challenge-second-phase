package com.fastfood.api.application.usecases.customer;

import com.fastfood.api.domain.entity.customer.Customer;

public interface CreateCustomerUseCase {
    Customer createCustomer (Customer customer);
}
