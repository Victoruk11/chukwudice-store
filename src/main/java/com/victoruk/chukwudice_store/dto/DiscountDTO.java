package com.victoruk.chukwudice_store.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.victoruk.chukwudice_store.entity.Product;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscountDTO {

    private Long id;

    private BigDecimal discountPercentage;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private Product product;

}
