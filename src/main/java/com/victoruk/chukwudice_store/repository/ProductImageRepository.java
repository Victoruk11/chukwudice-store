package com.victoruk.chukwudice_store.repository;

import com.victoruk.chukwudice_store.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductImageRepository  extends JpaRepository <ProductImage, Long> {

}
