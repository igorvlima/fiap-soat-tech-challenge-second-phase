package com.fastfood.api.infrastructure.controller.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductImageRequest(@NotBlank @NotNull String url) {
}
