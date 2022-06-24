package com.microservice.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
