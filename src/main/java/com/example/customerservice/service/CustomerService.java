package com.example.customerservice.service;

import com.example.customerservice.Entity.Customer;
import com.example.customerservice.exception.CustomerNotFoundException;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Save a new customer
    public Customer saveCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        return customerRepository.save(customer);
    }

    // Get customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by phone number
    public Optional<Customer> getCustomerByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    // Update an existing customer
    public Customer updateCustomer(Long id, Customer customerDetails) {
        if (customerDetails == null) {
            throw new IllegalArgumentException("Customer details cannot be null");
        }

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customer.setCustomerName(customerDetails.getCustomerName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        return customerRepository.save(customer);
    }

    // Delete customer by ID
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}
