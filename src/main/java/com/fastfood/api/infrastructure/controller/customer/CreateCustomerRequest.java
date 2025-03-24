package com.fastfood.api.infrastructure.controller.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerRequest(@NotNull @NotBlank String cpf, @NotNull @NotBlank String name, @NotNull @NotBlank String email) {
}
