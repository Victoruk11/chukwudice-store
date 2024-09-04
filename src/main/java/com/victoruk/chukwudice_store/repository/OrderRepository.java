package com.victoruk.chukwudice_store.repository;

import com.victoruk.chukwudice_store.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
