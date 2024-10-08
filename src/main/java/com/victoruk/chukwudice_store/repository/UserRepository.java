package com.victoruk.chukwudice_store.repository;

import com.victoruk.chukwudice_store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);


    Optional<User> findByUserName(String username);


}
