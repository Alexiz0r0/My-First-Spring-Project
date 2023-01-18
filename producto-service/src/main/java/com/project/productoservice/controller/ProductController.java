package com.project.productoservice.controller;

import com.project.productoservice.entity.Product;
import com.project.productoservice.model.Customer;
import com.project.productoservice.model.Supplier;
import com.project.productoservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productApi") /* productApi -> products */
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();
        if (products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Integer id){
        Product products = productService.getProductById(id);
        if (products == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping()
    public ResponseEntity<Product> getById(@RequestBody Product product){
        Product newProduct = productService.save(product);
        return ResponseEntity.ok(newProduct);
    }

    /* Imitar - create 2 class - model

    @GetMapping("/supplier/{productId}")
    public ResponseEntity<List<Supplier>> getSupplier(@PathVariable("productId") Integer productId){
        Product product = productService.getProductById(productId);
        if (product == null){
            return ResponseEntity.notFound().build();
        }
        List<Supplier> suppliers = productService.getSuppliers(productId);
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/costumer/{productId}")
    public ResponseEntity<List<Customer>> getCustomer(@PathVariable("productId") Integer productId){
        Product customer = productService.getProductById(productId);
        if (customer == null){
            return ResponseEntity.notFound().build();
        }
        List<Customer> customers = productService.getCustomers(productId);
        return ResponseEntity.ok(customers);
    }
    */

    /* Feign - Jam17 */
    /*
    @PostMapping("/saveNewCustomer/{productId}")
    public ResponseEntity<Customer> saveCustomer(@PathVariable("productId") Integer productId, @RequestBody Customer customer){
        if (productService.getProductById(productId) == null){
            return ResponseEntity.notFound().build();
        }
        Customer customerNew = productService.saveNewCustomer(productId,customer);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/saveNewSupplier/{productId}")
    public ResponseEntity<Supplier> saveSupplier(@PathVariable("productId") Integer productId, @RequestBody Supplier supplier){
        if (productService.getProductById(productId) == null){
            return ResponseEntity.notFound().build();
        }
        Supplier supplierNew = productService.saveNewSupplier(productId,supplier);
        return ResponseEntity.ok(supplier);
    }

    @GetMapping("/getAll/{productId}")
    public ResponseEntity<Map<String, Object>> getAllPeople(@PathVariable("productId") Integer productId){
        Map<String, Object> result = productService.getProductsAndPeople(productId);
        return ResponseEntity.ok(result);
    }
    */

    @GetMapping("/getAll/{productId}")
    public ResponseEntity<Map<String, Object>> getAllPeople(@PathVariable("productId") Integer productId){
        Map<String, Object> result = productService.getProductsAndPeople(productId);
        return ResponseEntity.ok(result);
    }

}
