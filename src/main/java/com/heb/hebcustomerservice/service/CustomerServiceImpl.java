package com.heb.hebcustomerservice.service;

import com.heb.hebcustomerservice.entity.Customer;
import com.heb.hebcustomerservice.exception.BadRequestException;
import com.heb.hebcustomerservice.exception.CustomerAlreadyExistsException;
import com.heb.hebcustomerservice.exception.CustomerNotFoundException;
import com.heb.hebcustomerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
private CustomerServiceImpl(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
}
    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findCustomerByCity(String city) {
        city = city.replaceAll("\"", "");
        List<Customer> customersByCity = customerRepository.findCustomerByCity(city);
        if(customersByCity.isEmpty()){
            throw new BadRequestException("No Such a City");
        }
        return customersByCity;
    }

    @Override
    public Customer findCustomerById(UUID customerId) throws CustomerNotFoundException {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " Not Found"));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer existingCustomer
                = customerRepository.findById(customer.getCustomerId())
                .orElse(null);
        Customer savedCustomer;
        if (existingCustomer == null) {
            savedCustomer =   customerRepository.save(customer);
            return savedCustomer;
        }
        else
            throw new CustomerAlreadyExistsException(
                    "Customer already exists in Database!!");
    }
}
