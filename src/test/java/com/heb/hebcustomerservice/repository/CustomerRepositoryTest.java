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
                .customerId(UUID.randomUUID())
                .firstName("Leah")
                .lastName("Mbambu")
                .emailAddress("lmbambu@domain.com")
                .state("Texas")
                .city("Georgetown")
                .zip("078562")
                .build();
    }
    @Test
    void findAllCustomers() {
        assertEquals(3, customerRepository.findAll().size());
    }

    @Test
    void findCustomerByCity() {
    }

    @Test
    void findCustomerById() {
    }

    @Test
    void createCustomer() {
    }
}