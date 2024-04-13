package com.heb.hebcustomerservice.controller;

import com.heb.hebcustomerservice.entity.Customer;
import com.heb.hebcustomerservice.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping(path = "/customers")
public class CustomerControllerImpl implements CustomerController {
    private final CustomerServiceImpl customerService;
    @Autowired
    public CustomerControllerImpl(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }
    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Customer>> findAllCustomers() {
     return ResponseEntity.ok(customerService.findAllCustomers());
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
