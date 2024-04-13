package com.heb.hebcustomerservice.controller;

import com.heb.hebcustomerservice.entity.Customer;
import com.heb.hebcustomerservice.exception.CustomerNotFoundException;
import com.heb.hebcustomerservice.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(
            value="/city/{cityName}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Customer>> findCustomerByCity(@PathVariable String cityName) {
        return ResponseEntity.ok(customerService.findCustomerByCity(cityName));
    }

    @Override
    @GetMapping(
            value="/{customerId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Customer> findCustomerById(@PathVariable UUID customerId) throws CustomerNotFoundException {
        return ResponseEntity.ok(customerService.findCustomerById(customerId));
    }

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }
}
