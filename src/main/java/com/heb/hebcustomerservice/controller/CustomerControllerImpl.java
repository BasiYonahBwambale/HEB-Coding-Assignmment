package com.heb.hebcustomerservice.controller;

import com.heb.hebcustomerservice.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class CustomerControllerImpl implements CustomerController {
    @Override
    public ResponseEntity findAllCustomers() {
        return null;
    }

    @Override
    public ResponseEntity findCustomerByCity(String city) {
        return null;
    }

    @Override
    public ResponseEntity findCustomerById(UUID cusomerId) {
        return null;
    }

    @Override
    public ResponseEntity createCustomer(Customer customer) {
        return null;
    }
}
