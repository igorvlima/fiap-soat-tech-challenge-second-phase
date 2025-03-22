package com.fastfood.api.infrastructure.gateways.customer;

import com.fastfood.api.domain.entity.customer.Customer;
import com.fastfood.api.infrastructure.persistence.customer.CustomerEntity;

public class CustomerEntityMapper {
    CustomerEntity toEntity(Customer customer) {
        return new CustomerEntity(customer);
    }

    Customer toDomainObj(CustomerEntity customerEntity) {
        return new Customer(customerEntity.getId(), customerEntity.getCpf(), customerEntity.getName(),
                customerEntity.getEmail(), customerEntity.getActive(), customerEntity.getCreatedAt(), customerEntity.getUpdatedAt());
    }
}
