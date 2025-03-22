package com.fastfood.api.infrastructure.persistence.product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE ProductEntity p SET p.active = false, p.updatedAt = CURRENT_TIMESTAMP WHERE p.id = :id")
    void disableProductById(@Param("id") Long id);

    @Query("SELECT p FROM ProductEntity p WHERE p.category = :category AND p.active = true")
    List<ProductEntity> findProductByCategory(@Param("category") String category);
}
