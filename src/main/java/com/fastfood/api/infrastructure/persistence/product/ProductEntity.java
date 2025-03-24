package com.fastfood.api.infrastructure.persistence.product;

import com.fastfood.api.domain.entity.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "product")
@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "product_seq_gen", sequenceName = "product_id_seq", allocationSize = 1)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String category;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.active = product.getActive();
        this.category = product.getCategory().toString();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }
}

