package com.example.customerservice.exception;

public class CustomerNotFoundException extends RuntimeException {

    // Constructor to pass the exception message
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
