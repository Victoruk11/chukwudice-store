package com.victoruk.chukwudice_store.repository;

import com.victoruk.chukwudice_store.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
