package com.naumov.transactionservice.repository;

import com.naumov.transactionservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.Instant;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findByDateCreate(Instant date);
}
