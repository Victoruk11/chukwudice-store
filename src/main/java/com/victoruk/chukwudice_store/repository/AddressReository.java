package com.victoruk.chukwudice_store.repository;

import com.victoruk.chukwudice_store.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressReository extends JpaRepository<Address,Long> {

}
