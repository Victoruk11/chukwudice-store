package com.victoruk.chukwudice_store.mapper;


import com.victoruk.chukwudice_store.dto.OrderDTO;
import com.victoruk.chukwudice_store.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, OrderItemMapper.class, AddressMapper.class})
public interface OrderMapper {

//        @Mapping(source = "oderStatus", target = "orderStatus")
        OrderDTO toOrderDTO(Order order);

//        @InheritInverseConfiguration
        Order toOrder(OrderDTO orderDTO);



}
