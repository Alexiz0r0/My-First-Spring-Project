package com.project.proveedorservice.service;

import com.project.proveedorservice.entity.Supplier;
import com.project.proveedorservice.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAll(){
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers;
    }

    public Supplier save(Supplier supplier){
        Supplier supplierNew = supplierRepository.save(supplier);
        return supplierNew;
    }

    public Supplier getSupplierById(Integer id){
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier newGetById(Integer id) throws SupplierNotFound{
        Optional<Supplier> result = supplierRepository.findById(id);

        if (result.isPresent()){
            return result.get();
        }
        throw new SupplierNotFound("No se encontro un proveedor con el Id "+id);
    }
    public void deleteById(Integer id) throws SupplierNotFound {
        Long count = supplierRepository.countById(id);
        if (count == null || count == 0){
            throw new SupplierNotFound("No se encontro un proveedor con el Id "+ id);
        }
        supplierRepository.deleteById(id);
    }

    /* Add new function-service to make a relational DB between Customers -> Products */
    public List<Supplier> byProductId(Integer productId){
        return supplierRepository.findByProductId(productId);
    }
}
