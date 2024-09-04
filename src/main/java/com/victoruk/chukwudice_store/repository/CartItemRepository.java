package com.victoruk.chukwudice_store.repository;

import com.victoruk.chukwudice_store.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
