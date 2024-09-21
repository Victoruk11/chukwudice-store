package com.victoruk.chukwudice_store.mapper;

import com.victoruk.chukwudice_store.dto.AddressDTO;
import com.victoruk.chukwudice_store.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

        AddressDTO toDTO(Address address);

        Address toEntity(AddressDTO addressDTO);


}
