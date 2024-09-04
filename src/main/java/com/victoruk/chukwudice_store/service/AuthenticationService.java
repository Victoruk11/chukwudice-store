package com.victoruk.chukwudice_store.service;

import com.victoruk.chukwudice_store.entity.User;
import com.victoruk.chukwudice_store.filter.AuthenticationResponse;
import com.victoruk.chukwudice_store.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.victoruk.chukwudice_store.entity.Address;
import com.victoruk.chukwudice_store.entity.Cart;
import com.victoruk.chukwudice_store.entity.Role;

import jakarta.transaction.Transactional;

import java.time.LocalDate;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public AuthenticationResponse register(User request) {

        // Check if email or username already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalStateException("Email already in use");
        }

        // Create new User entity
        User user = new User();
        user.setUserName(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassWord(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
//        user.setCreatedAt(LocalDate.now());
//        user.setUpdatedAt(LocalDate.now());

        // Assign role; default to USER if not provided
        if (request.getRole() != null) {
            user.setRole(request.getRole());
        } else {
            user.setRole(Role.USER);
        }

        // Initialize related entities
        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        Address address = new Address();
        address.setUser(user);
        user.setAddress(address);

        // Orders list is already initialized in the User entity

        // Save the user to the repository
        User savedUser = userRepository.save(user);

        // Generate JWT token
        String token = jwtService.generateToken(savedUser);

        return new AuthenticationResponse(token);
    }



    public  AuthenticationResponse authenticate(User request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}

