package com.microservice.customer;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
