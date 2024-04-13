package com.heb.hebcustomerservice.service;

import com.heb.hebcustomerservice.entity.Customer;
import com.heb.hebcustomerservice.exception.CustomerNotFoundException;
import com.heb.hebcustomerservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
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
        assertEquals(customers, customerService.findCustomerByCity("Piscatway"));
    }

    @Test
    void findCustomerById() throws CustomerNotFoundException {
        when(customerRepository.findById(any())).thenReturn(Optional.ofNullable(customer));
        assertEquals(customer, customerService.findCustomerById(UUID.randomUUID()));
    }

    @Test
    public void getDemoNotFound(){
        when(customerRepository.findById(UUID.fromString("587377f9-d630-4363-a9cf-bcd9acd3846d")))
                .thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class,
                () -> customerService.findCustomerById(UUID.fromString("587377f9-d630-4363-a9cf-bcd9acd3846d")));
    }

    @Test
    void createCustomer() {
        when(customerRepository.save(customer)).thenReturn(customer);
        assertEquals(customer, customerService.createCustomer(customer));
    }
}