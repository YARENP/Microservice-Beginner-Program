package com.microservice.customer;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.domain.Sort;
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
        return customerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Integer id, CustomerRegistrationRequest customerRequest) {
        Customer customer = customerRepository.getById(id);
        customer.setFirstName(customerRequest.firstName());
        customer.setLastName(customerRequest.lastName());
        customer.setEmail(customerRequest.email());
        customerRepository.save(customer);
    }
}
