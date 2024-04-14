package com.heb.hebcustomerservice.repository;

import com.heb.hebcustomerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    @Query("SELECT c FROM Customer c WHERE c.city = :customerCity")
    List<Customer> findCustomerByCity(String customerCity);
}
