package com.victoruk.chukwudice_store.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate expiryDate;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private CategoryDTO category;
    private List<ProductImageDTO> productImages = new ArrayList<>();
    private List<CartItemDTO> cartItems  = new ArrayList<>();
    private List<ProductDamageDTO> productDamages  = new ArrayList<>();
}
