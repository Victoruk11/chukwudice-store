package com.victoruk.chukwudice_store.service.serviceimplementation;

import com.victoruk.chukwudice_store.dto.LoginRequest;
import com.victoruk.chukwudice_store.dto.Response;
import com.victoruk.chukwudice_store.dto.UserDTO;
import com.victoruk.chukwudice_store.entity.Role;
import com.victoruk.chukwudice_store.entity.User;
import com.victoruk.chukwudice_store.exception.OurException;
import com.victoruk.chukwudice_store.mapper.UserMapper;
import com.victoruk.chukwudice_store.repository.UserRepository;
import com.victoruk.chukwudice_store.service.JwtService;
//import com.victoruk.chukwudice_store.service.userserviceinterfac.Userinterface;
import com.victoruk.chukwudice_store.service.interfac.Userinterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements Userinterface {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private final UserMapper userMapper;
    private  final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public UserService(UserMapper userMapper, UserRepository userRepository, PasswordEncoder passwordEncoder, com.victoruk.chukwudice_store.service.JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Response registerUser(User user) {

        Response response = new Response();

        try {

        if (user.getRole() == null){

            user.setRole(Role.USER);
        }
        if (userRepository.existsByEmail(user.getEmail())){
            throw new OurException (user.getEmail() + "  This User Already Exist");
        }

        user.setPassWord(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        UserDTO userDTO = userMapper.toUserDTO(savedUser);
        response.setStatusCode(201);
        response.setMessage("User registered successfully.");
        response.setData(Map.of("user", userDTO));

        } catch (OurException e) {

            logger.warn("User registration failed: {}", e.getMessage());
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
//            response.setStatusCode(400);
//            response.setMessage(e.getMessage());
        }catch (Exception e) {

            logger.error("An error occurred during user registration", e);
            response.setStatusCode(500);
            response.setMessage("An unexpected error occurred. Please try again later.");
        }

        return response;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        Response response = new Response();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassWord()));
            var user = userRepository.findByUserName(loginRequest.getEmail()).orElseThrow(()-> new OurException("User not found"));

            var token = jwtService.generateToken(user);
            response.setStatusCode(200);
            response.setToken(token);
            response.setRole(user.getRole());
            response.setExpirationTime("7 Days");
            response.setMessage("successful");

        }catch (OurException e){
            logger.warn("User login failed: {}", e.getMessage());
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred during user login ", e);
            response.setStatusCode(500);
            response.setMessage("An unexpected error occurred. Please try again later.");
        }

        return response;
    }

    @Override
    public Response getAllUsers() {
        Response response = new Response();

        try {
            // Fetch all users
            List<User> userList = userRepository.findAll();

            // Map the list of User entities to UserDTOs
            List<UserDTO> userDTOList = userMapper.toUserDTO(userList);

            // Set response data
            response.setStatusCode(200);
            response.setMessage("Successfully fetched all users.");
            response.setData(Map.of("users", userDTOList));

        } catch (OurException e) {
            logger.error("An error occurred while fetching users", e);
            response.setStatusCode(500);
            response.setMessage("An unexpected error occurred. Please try again later.");
        }

        return response;
    }


    @Override
    public Response getUserById(String userId) {
        return null;
    }

    @Override
    public Response getUserOrderHistory(String userId) {
        return null;
    }

    @Override
    public Response getMyInfo(String email) {
        return null;
    }
}
