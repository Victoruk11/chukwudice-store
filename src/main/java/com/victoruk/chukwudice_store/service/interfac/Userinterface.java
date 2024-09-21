package com.victoruk.chukwudice_store.service.interfac;

import com.victoruk.chukwudice_store.dto.LoginRequest;
import com.victoruk.chukwudice_store.dto.Response;
import com.victoruk.chukwudice_store.entity.User;

public interface Userinterface {

    Response registerUser (User user);

    Response  login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserById(String userId);

    Response getUserOrderHistory(String userId);

    Response getMyInfo( String email);
}
