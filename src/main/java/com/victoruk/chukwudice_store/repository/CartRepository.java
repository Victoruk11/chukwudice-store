package com.victoruk.chukwudice_store.repository;

import com.victoruk.chukwudice_store.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
