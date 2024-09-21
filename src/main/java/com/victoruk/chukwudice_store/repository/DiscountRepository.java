package com.victoruk.chukwudice_store.repository;

import com.victoruk.chukwudice_store.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
