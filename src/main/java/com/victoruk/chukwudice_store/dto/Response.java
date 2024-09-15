package com.victoruk.chukwudice_store.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Response {

    private int statusCode;
    private String message;

    // Authentication-related fields
    private String token;
    private String role;
    private String expirationTime;
    private String orderConfirmationCode;

    // Dynamic payload field for both single DTOs and lists of DTOs
    private Map<String, Object> data;

//
//
//    private AddressDTO addressDTO;
//    private CartDTO cartDTO;
//    private CartItemDTO cartItemDTO;
//    private CategoryDTO categoryDTO;
//    private DiscountDTO discountDTO;
//    private OrderDTO orderDTO;
//    private OrderItemDTO orderItemDTO;
//    private ProductDamageDTO productDamageDTO;
//    private ProductDTO productDTO;
//    private ProductImageDTO productImageDTO;
//    UserDTO userDTO;
//
//    private List<AddressDTO> addressDTOList;
//    private List<CartDTO> cartDTOList;
//    private List<CartItemDTO> cartItemDTOList;
//    private List<CategoryDTO> categoryDTOList;
//    private List<DiscountDTO> discountDTOList;
//    private List<OrderDTO> orderDTOList;
//    private List<OrderItemDTO> orderItemDTOList;
//    private List<ProductDamageDTO> productDamageDTOList;
//    private List<ProductDTO> productDTOList;
//    private List<ProductImageDTO> productImageDTOList;
//    private List<UserDTO> userDTOList;

}
