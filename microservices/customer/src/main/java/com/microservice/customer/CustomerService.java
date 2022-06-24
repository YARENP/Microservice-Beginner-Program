package com.microservice.customer;

import org.springframework.stereotype.Service;

// this is a spring service therefore we have to annotate with service keyword
@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();

        //todo: validate emial lastname and firstname
        customerRepository.save(customer);
    }
}
