package com.project.clienteservice.controller;

import com.project.clienteservice.entity.Customer;
import com.project.clienteservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerApi") /* customerApi -> clientes */
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customers = customerService.getAll();
        if (customers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Integer id){
        Customer customers = customerService.getCustomerById(id);
        if (customers == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customers);
    }

    @PostMapping()
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        Customer newCustomer = customerService.save(customer);
        return ResponseEntity.ok(newCustomer);
    }

    /* Add new function-control to make a relational DB between Customers -> Products */
    @GetMapping("/byproduct/{productId}")
    public ResponseEntity<List<Customer>> getByProductId(@PathVariable("productId") Integer productId){

        List<Customer> customers = customerService.byProductId(productId);
        /*
        if (customers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        */
        return ResponseEntity.ok(customers);
    }


}
