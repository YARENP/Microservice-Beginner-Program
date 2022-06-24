package com.microservice.customer;

import lombok.Builder;
import lombok.Data;

// customer is the model of this microservice
// to tell the spring this is a model we have to annotate as follows
@Data
@Builder
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private Integer id;

}
