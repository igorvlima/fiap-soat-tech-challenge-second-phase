package com.fastfood.api.infrastructure.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface ProductImageRepository extends JpaRepository<ProductImageEntity, Long> {
    List<ProductImageEntity> findByProductId(Long productId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProductImageEntity i WHERE i.productId = :productId")
    void deleteAllImagesByProductId(Long productId);
}
