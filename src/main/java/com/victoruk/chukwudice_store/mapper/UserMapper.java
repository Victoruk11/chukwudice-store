package com.victoruk.chukwudice_store.mapper;

import com.victoruk.chukwudice_store.dto.UserDTO;
import com.victoruk.chukwudice_store.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {CartMapper.class, OrderMapper.class, AddressMapper.class})
public interface UserMapper {

        UserDTO toUserDTO(User user);

        User toUser(UserDTO userDTO);

}
