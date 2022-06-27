package com.microservice.customer;

import com.sun.xml.bind.v2.model.core.ID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
// this is the controller of the project, as you know spring has mvc structure and controller is responsible for api operations
// also knowns as rest controller
@RestController
// then we specify which url path this program will work
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    // it is the register post method, we are going to get this request from api
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("customer registration{} ", customerRequest);
        customerService.registerCustomer(customerRequest);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping(path = "{id}")
    public void getAllPeople(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping(path = "{id}")
    public void updateCustomer(@PathVariable("id") Integer id, @RequestBody CustomerRegistrationRequest customerRequest) {
        customerService.updateCustomer(id, customerRequest);
    }
//    @GetMapping(path = "{id}")
//    public Optional<Person> getPersonById(@PathVariable("id") UUID id) {
//        return Optional.ofNullable(personService.getPersonById(id).orElse(null));
//    }
}
