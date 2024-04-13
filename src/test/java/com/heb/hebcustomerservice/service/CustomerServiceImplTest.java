package com.heb.hebcustomerservice.service;

import com.heb.hebcustomerservice.entity.Customer;
import com.heb.hebcustomerservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
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
        List<Customer> customers = Arrays.asList(customer);
        when(customerRepository.findAll()).thenReturn(customers);
        assertEquals(customers, customerService.findAllCustomers());
    }

    @Test
    void findCustomerByCity() {
        List<Customer> customers = Arrays.asList(customer);
        when(customerRepository.findCustomerByCity(anyString())).thenReturn(customers);
        assertEquals(customers, customerService.findAllCustomers());
    }

    @Test
    void findCustomerById() {
    }

    @Test
    void createCustomer() {
    }
}