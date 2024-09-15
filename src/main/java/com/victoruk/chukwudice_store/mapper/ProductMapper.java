package com.victoruk.chukwudice_store.mapper;

import com.victoruk.chukwudice_store.dto.ProductDTO;
import com.victoruk.chukwudice_store.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductImageMapper.class, DiscountMapper.class})
public interface ProductMapper {


        ProductDTO toProductDTO(Product product);


        Product toProduct(ProductDTO productDTO);


}
