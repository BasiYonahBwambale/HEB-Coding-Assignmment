package com.heb.hebcustomerservice.controller;

import com.heb.hebcustomerservice.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CustomerController {
    ResponseEntity findAllCustomers();
    ResponseEntity findCustomerByCity(String city);
    ResponseEntity findCustomerById(UUID cusomerId);
    ResponseEntity createCustomer(Customer customer);

}
