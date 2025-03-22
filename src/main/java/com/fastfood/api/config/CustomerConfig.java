package com.fastfood.api.config;

import com.fastfood.api.application.gateways.CustomerGateway;
import com.fastfood.api.application.usecases.customer.CreateCustomerImpl;
import com.fastfood.api.application.usecases.customer.DisableCustomerByIdByIdImpl;
import com.fastfood.api.application.usecases.customer.FindCustomerByCpfImpl;
import com.fastfood.api.application.usecases.customer.FindCustomerByIdImpl;
import com.fastfood.api.infrastructure.controller.customer.CustomerDTOMapper;
import com.fastfood.api.infrastructure.gateways.customer.CustomerEntityMapper;
import com.fastfood.api.infrastructure.gateways.customer.CustomerRepositoryGateway;
import com.fastfood.api.infrastructure.persistence.customer.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    CreateCustomerImpl createCustomerImpl(CustomerGateway customerGateway) {
        return new CreateCustomerImpl(customerGateway);
    }

    @Bean
    FindCustomerByIdImpl findCustomerByIdImpl(CustomerGateway customerGateway) {
        return new FindCustomerByIdImpl(customerGateway);
    }

    @Bean
    FindCustomerByCpfImpl findCustomerByCpfImpl(CustomerGateway customerGateway) {
        return new FindCustomerByCpfImpl(customerGateway);
    }

    @Bean
    DisableCustomerByIdByIdImpl disableCustomerByIdByIdImpl(CustomerGateway customerGateway) {
        return new DisableCustomerByIdByIdImpl(customerGateway);
    }

    @Bean
    public CustomerGateway customerGateway(CustomerRepository repository, CustomerEntityMapper mapper) {
        return new CustomerRepositoryGateway(repository, mapper);
    }

    @Bean
    CustomerEntityMapper customerEntityMapper() {return new CustomerEntityMapper();}

    @Bean
    CustomerDTOMapper customerDTOMapper() {return new CustomerDTOMapper();}
}
