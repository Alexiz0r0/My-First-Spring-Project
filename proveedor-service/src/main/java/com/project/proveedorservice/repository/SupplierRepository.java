package com.project.proveedorservice.repository;

import com.project.proveedorservice.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    public Long countById(Integer id);

    /* Add new function to make a relational DB between Customers -> Products */
    List<Supplier> findByProductId(Integer supplierId);

}
