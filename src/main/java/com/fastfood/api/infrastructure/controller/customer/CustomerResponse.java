package com.fastfood.api.infrastructure.controller.customer;

import java.time.LocalDateTime;

public record CustomerResponse(Long id, String cpf, String name, String email, Boolean active,
                               LocalDateTime createdAt, LocalDateTime updatedAt) {
}
