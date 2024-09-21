package com.victoruk.chukwudice_store.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.victoruk.chukwudice_store.entity.Role;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String userName;
    private String email;
    private String phoneNumber;
    private Role role;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private CartDTO cart;
    private List<OrderDTO> orders = new ArrayList<>();
    private AddressDTO address;
}
