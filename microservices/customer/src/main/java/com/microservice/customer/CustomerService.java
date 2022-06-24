package com.microservice.customer;

import org.springframework.stereotype.Service;

// this is a spring service therefore we have to annotate with service keyword
@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();

        //todo: validate emial lastname and firstname
        //todo: save the customer into database
    }
}
