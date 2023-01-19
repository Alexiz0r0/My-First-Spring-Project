package com.project.productoservice.feignclients;

import com.project.productoservice.model.Supplier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "proveedor-service")
public interface SupplierFeignClient {

    /*

    , url = "http://localhost:8003/supplierApi"

    @PostMapping()
    Supplier save(@RequestBody Supplier supplier);


    @GetMapping("/byproduct/{productId}")
    List<Supplier> getSuppliers(@PathVariable("productId") Integer productId);
    */

    @GetMapping("/byproduct/{productId}")
    public List<Supplier> getByProductId(@PathVariable("productId") Integer productId);
}
