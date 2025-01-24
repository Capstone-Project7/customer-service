package com.example.customerservice.service;

import com.example.customerservice.Entity.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhone(customerDetails.getPhone());
        return repository.save(customer);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
