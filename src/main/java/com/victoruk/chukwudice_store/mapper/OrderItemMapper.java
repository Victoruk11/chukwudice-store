package com.victoruk.chukwudice_store.mapper;


import com.victoruk.chukwudice_store.dto.OrderItemDTO;
import com.victoruk.chukwudice_store.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface OrderItemMapper {

        OrderItemDTO toOrderItemDTO(OrderItem orderItem);

        OrderItem toOrderItem(OrderItemDTO orderItemDTO);

}
