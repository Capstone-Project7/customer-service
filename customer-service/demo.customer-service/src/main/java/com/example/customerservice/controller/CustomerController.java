
package com.example.customerservice.controller;

import com.example.customerservice.Entity.Customer;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        return service.updateCustomer(id, customerDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}
