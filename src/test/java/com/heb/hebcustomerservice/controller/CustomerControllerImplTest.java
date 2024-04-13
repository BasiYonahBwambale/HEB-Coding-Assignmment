package com.heb.hebcustomerservice.controller;

import com.heb.hebcustomerservice.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerImplTest {

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