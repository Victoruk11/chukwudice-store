package com.victoruk.chukwudice_store.mapper;

import com.victoruk.chukwudice_store.dto.ProductImageDTO;
import com.victoruk.chukwudice_store.entity.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ProductImageMapper {

        ProductImageDTO toProductImageDTO(ProductImage productImage);

        ProductImage toProductImage(ProductImageDTO productImageDTO);

}
