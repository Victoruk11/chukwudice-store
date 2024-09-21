package com.victoruk.chukwudice_store.mapper;

import com.victoruk.chukwudice_store.dto.DiscountDTO;
import com.victoruk.chukwudice_store.entity.Discount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface DiscountMapper {


        DiscountDTO toDTO(Discount discount);

        Discount toEntity(DiscountDTO discountDTO);

}
