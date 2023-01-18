package com.project.productoservice.service;

import com.project.productoservice.entity.Product;
import com.project.productoservice.feignclients.CustomerFeignClient;
import com.project.productoservice.feignclients.SupplierFeignClient;
import com.project.productoservice.model.Customer;
import com.project.productoservice.model.Supplier;
import com.project.productoservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /* Communication between services */
    @Autowired
    RestTemplate restTemplate;

    /*Add Ja17*/
    @Autowired
    CustomerFeignClient customerFeignClient;
    @Autowired
    SupplierFeignClient supplierFeignClient;

    public List<Product> getAll(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product save(Product product){
        Product productNew = productRepository.save(product);
        return productNew;
    }

    public Product getProductById(Integer id){
        return productRepository.findById(id).orElse(null);
    }

    public Optional<Product> getById(Integer id){
        return productRepository.findById(id);
    }

    /* Imitar - create 2 class - model

    public List<Supplier> getSuppliers(Integer productId){
        List<Supplier> suppliers = restTemplate.getForObject("http://localhost:8003/supplierApi/byproduct/"+productId, List.class);
        return  suppliers;
    }

    public List<Customer> getCustomers(Integer productId){
        List<Customer> customers = restTemplate.getForObject("http://localhost:8002/customerApi/byproduct/"+productId, List.class);
        return customers;
    }
    */

    /*Add Ja17*/
    /*
    public Customer saveNewCustomer(Integer productId, Customer customer){

        customer.setProductId(productId);

        Customer customerNew = customerFeignClient.save(customer);
        return customerNew;
    }

    public Supplier saveNewSupplier(Integer productId, Supplier supplier){
        supplier.setProductId(productId);
        Supplier supplierNew = supplierFeignClient.save(supplier);
        return supplierNew;
    }


    public Map<String, Object> getProductsAndPeople(Integer productId){
        Map<String, Object> result = new HashMap<>();
        Product product = productRepository.findById(productId).orElse(null);
        if(product == null){
            result.put("Mensaje", "No existe el producto");
            return  result;
        }
        result.put("Product",product);
        List<Customer> customers = customerFeignClient.getCustomers(productId);
        if (customers.isEmpty()){
            result.put("Customer", "El producto no tiene cliente");
        } else {
            result.put("Customer", customers);
        }
        List<Supplier> suppliers = supplierFeignClient.getSuppliers(productId);
        if (suppliers.isEmpty()){
            result.put("Supplier", "El producto no tiene proveedor");
        } else {
            result.put("Supplier", suppliers);
        }
        return result;
    }
    */

    public Map<String, Object> getProductsAndPeople(Integer productId){
        Map<String, Object> result = new HashMap<>();
        Product product = productRepository.findById(productId).orElse(null);
        if(product == null){
            result.put("Mensaje", "No existe el producto");
            return  result;
        }
        result.put("Product",product);
        List<Customer> customers = customerFeignClient.getByProductId(productId);
        if (customers.isEmpty()){
            result.put("Customer", "El producto"+" Id("+productId+")"+" no tiene cliente");
        } else {
            result.put("Customer", customers);
        }
        List<Supplier> suppliers = supplierFeignClient.getByProductId(productId);
        if (suppliers.isEmpty()){
            result.put("Supplier", "El producto"+" Id("+productId+")"+" no tiene proveedor");
        } else {
            result.put("Supplier", suppliers);
        }
        return result;
    }
}
