package com.heb.hebcustomerservice.service;

import com.heb.hebcustomerservice.entity.Customer;
import com.heb.hebcustomerservice.exception.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> findAllCustomers();
    List<Customer> findCustomerByCity(String city);
    Customer findCustomerById(UUID customerId) throws CustomerNotFoundException;
    Customer createCustomer(Customer customer);
}
