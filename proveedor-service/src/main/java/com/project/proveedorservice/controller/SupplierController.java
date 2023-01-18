package com.project.proveedorservice.controller;

import com.project.proveedorservice.entity.Supplier;
import com.project.proveedorservice.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/supplierApi") /* supplierApi -> suppliers */
@RestController

public class SupplierController {

    @Autowired
    SupplierService supplierService;
    @GetMapping
    public ResponseEntity<List<Supplier>> getAll(){
        List<Supplier> suppliers = supplierService.getAll();
        if (suppliers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(suppliers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable("id") Integer id){
        Supplier suppliers = supplierService.getSupplierById(id);
        if (suppliers == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(suppliers);
    }

    @PostMapping()
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier){
        Supplier newSupplier = supplierService.save(supplier);
        return ResponseEntity.ok(newSupplier);
    }

    /* Add new function-control to make a relational DB between Customers -> Products */
    @GetMapping("/byproduct/{productId}")
    public ResponseEntity<List<Supplier>> getByProductId(@PathVariable("productId") Integer productId){

        List<Supplier> suppliers = supplierService.byProductId(productId);
        /*
        if (suppliers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        */
        return ResponseEntity.ok(suppliers);
    }
}
