package com.microservice.customer;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import java.util.List;

// this is a spring service therefore we have to annotate with service keyword
@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();

        //todo: validate emial lastname and firstname
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

}
