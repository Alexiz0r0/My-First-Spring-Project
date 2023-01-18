package com.project.clienteservice.repository;

import ch.qos.logback.core.net.server.Client;
import com.project.clienteservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    /* Add new function to make a relational DB between Customers -> Products */
    List<Customer> findByProductId(Integer customerId);

}
