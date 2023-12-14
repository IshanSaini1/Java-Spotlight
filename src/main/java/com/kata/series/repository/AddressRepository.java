package com.kata.series.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kata.series.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
