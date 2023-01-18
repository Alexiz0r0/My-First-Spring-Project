package com.project.clienteservice.service;

import com.project.clienteservice.entity.Customer;
import com.project.clienteservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer save(Customer customer){
        Customer customerNew = customerRepository.save(customer);
        return customerNew;
    }

    public Customer getCustomerById(Integer id){
        return customerRepository.findById(id).orElse(null);
    }

    /* Add new function-service to make a relational DB between Customers -> Products */
    public List<Customer> byProductId(Integer productId){
        return customerRepository.findByProductId(productId);
    }
}
