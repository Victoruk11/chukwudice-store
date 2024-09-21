package com.victoruk.chukwudice_store.mapper;

import com.victoruk.chukwudice_store.dto.CartItemDTO;
import com.victoruk.chukwudice_store.entity.CartItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CartItemMapper {



        CartItemDTO toDTO(CartItem cartItem);

        CartItem toEntity(CartItemDTO cartItemDTO);

}
