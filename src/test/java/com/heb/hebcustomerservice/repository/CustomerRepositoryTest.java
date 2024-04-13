package com.heb.hebcustomerservice.repository;

import com.heb.hebcustomerservice.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    @BeforeEach
    public void SetUp(){
        customer = Customer.builder()
                .customerId(UUID.fromString("7db51f02-9086-4797-a0c6-ce56ae5af5fe"))
                .firstName("Bruce")
                .lastName("Underson")
                .emailAddress("bruceunderson@gmail.com")
                .state("NewJersey")
                .city("Piscatway")
                .zip("08845")
                .build();
    }
    @Test
    void findAllCustomers() {
        assertEquals(3, customerRepository.findAll().size());
    }

    @Test
    void findCustomerByCity() {
        assertEquals(2, customerRepository.findCustomerByCity("Edison").size());
    }

    @Test
    void findCustomerById() {
        assertEquals(customer, customerRepository.findById(UUID.fromString("7db51f02-9086-4797-a0c6-ce56ae5af5fe")).get());
    }

    @Test
    void createCustomer() {
        assertEquals(customer, customerRepository.save(customer) );
    }
}