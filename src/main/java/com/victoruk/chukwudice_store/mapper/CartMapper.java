package com.victoruk.chukwudice_store.mapper;

import com.victoruk.chukwudice_store.dto.CartDTO;
import com.victoruk.chukwudice_store.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CartItemMapper.class})
public interface CartMapper {


        CartDTO toDTO(Cart cart);


        Cart toEntity(CartDTO cartDTO);

}
