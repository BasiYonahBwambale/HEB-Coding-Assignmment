package com.heb.hebcustomerservice.controller;

import com.heb.hebcustomerservice.entity.Customer;
import com.heb.hebcustomerservice.exception.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CustomerController {
    ResponseEntity findAllCustomers();
    ResponseEntity findCustomerByCity(String city);
    ResponseEntity findCustomerById(UUID cusomerId) throws CustomerNotFoundException;
    ResponseEntity createCustomer(Customer customer);

}
