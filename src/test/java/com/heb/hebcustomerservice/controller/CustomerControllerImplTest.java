package com.heb.hebcustomerservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heb.hebcustomerservice.entity.Customer;
import com.heb.hebcustomerservice.repository.CustomerRepository;
import com.heb.hebcustomerservice.service.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@WebMvcTest
class CustomerControllerImplTest {
    @MockBean
    private CustomerServiceImpl customerService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
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
    void findAllCustomers() throws Exception {
        Mockito.when(customerService.findAllCustomers()).thenReturn(List.of(customer));
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(List.of(customer))))
                .andReturn();
    }

    @Test
    void findCustomerByCity() throws Exception {
        Mockito.when(customerService.findCustomerByCity(anyString())).thenReturn(List.of(customer));
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/" + "Edison")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(List.of(customer))))
                .andReturn();
    }

    @Test
    void findCustomerById() {
    }

    @Test
    void createCustomer() {
    }
}