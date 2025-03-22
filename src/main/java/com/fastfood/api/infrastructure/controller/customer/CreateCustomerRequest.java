package com.fastfood.api.infrastructure.controller.customer;

public record CreateCustomerRequest(String cpf, String name, String email) {
}
