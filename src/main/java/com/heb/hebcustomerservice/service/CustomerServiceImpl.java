package com.heb.hebcustomerservice.service;

import com.heb.hebcustomerservice.entity.Customer;
import com.heb.hebcustomerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
private CustomerServiceImpl(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
}
    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findCustomerByCity(String city) {
        return customerRepository.findCustomerByCity(city);
    }

    @Override
    public Customer findCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }
}
