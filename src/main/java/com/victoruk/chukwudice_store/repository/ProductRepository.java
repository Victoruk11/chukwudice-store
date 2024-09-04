package com.victoruk.chukwudice_store.repository;

import com.victoruk.chukwudice_store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
