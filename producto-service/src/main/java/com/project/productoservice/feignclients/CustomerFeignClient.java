package com.project.productoservice.feignclients;

import com.project.productoservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "cliente-service", url = "http://localhost:8002/customerApi")
public interface CustomerFeignClient {

    /*
    @PostMapping()
    Customer save(@RequestBody Customer customer);


    @GetMapping("/byproduct/{productId}")
    List<Customer> getCustomers(@PathVariable("productId") Integer productId);
    */

    @GetMapping("/byproduct/{productId}")
    public List<Customer> getByProductId(@PathVariable("productId") Integer productId);
}
