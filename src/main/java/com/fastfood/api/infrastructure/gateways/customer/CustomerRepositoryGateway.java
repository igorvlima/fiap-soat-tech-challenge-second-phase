package com.fastfood.api.infrastructure.gateways.customer;

import com.fastfood.api.application.exceptions.CustomerNotFoundException;
import com.fastfood.api.application.gateways.CustomerGateway;
import com.fastfood.api.domain.entity.customer.Customer;
import com.fastfood.api.infrastructure.persistence.customer.CustomerRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public class CustomerRepositoryGateway implements CustomerGateway {

    private final CustomerRepository repository;
    private final CustomerEntityMapper mapper;

    public CustomerRepositoryGateway(CustomerRepository repository, CustomerEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setActive(true);
        customer.setCreatedAt(LocalDateTime.now());
        var customerEntity = mapper.toEntity(customer);
        var savedEntity = repository.save(customerEntity);

        return mapper.toDomainObj(savedEntity);
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return this.repository.findById(id)
                .map(mapper::toDomainObj)
                .or(() -> {
                    throw new CustomerNotFoundException("Cliente com ID " + id + " não encontrado");
                });
    }

    @Override
    public Optional<Customer> findCustomerByCpf(String cpf) {
        return this.repository.findByCpf(cpf)
                .map(mapper::toDomainObj)
                .or(() -> {
                    throw new CustomerNotFoundException("Cliente com CPF " + cpf + " não encontrado");
                });
    }

    @Override
    public void disableCustomerById(Long id) {
        repository.disableCustomerById(id);
    }
}
