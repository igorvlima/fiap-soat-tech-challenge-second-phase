package com.fastfood.api.infrastructure.persistence.customer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByCpf(String cpf);

    @Transactional
    @Modifying
    @Query("UPDATE CustomerEntity c SET c.active = false, c.updatedAt = CURRENT_TIMESTAMP WHERE c.id = :id")
    void disableCustomerById(@Param("id") Long id);
}
