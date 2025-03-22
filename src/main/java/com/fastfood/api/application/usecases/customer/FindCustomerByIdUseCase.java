package com.fastfood.api.application.usecases.customer;

import com.fastfood.api.domain.entity.customer.Customer;

public interface FindCustomerByIdUseCase {
    Customer findCustomerById (Long id);
}
