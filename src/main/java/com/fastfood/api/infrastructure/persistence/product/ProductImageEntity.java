package com.fastfood.api.infrastructure.persistence.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "product_image")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "product_image_seq_gen", sequenceName = "product_image_id_seq", allocationSize = 1)
public class ProductImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_image_seq_gen")
    private Long id;
    private Long productId;
    private String url;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductImageEntity(Long productId, String url, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.url = url;
        this.productId = productId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
