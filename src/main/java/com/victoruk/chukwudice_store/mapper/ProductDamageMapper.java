package com.victoruk.chukwudice_store.mapper;


import com.victoruk.chukwudice_store.dto.ProductDamageDTO;
import com.victoruk.chukwudice_store.entity.ProductDamage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ProductDamageMapper {


        ProductDamageDTO toProductDamageDTO(ProductDamage productDamage);

        ProductDamage toProductDamage(ProductDamageDTO productDamageDTO);


}
