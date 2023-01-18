package com.project.proveedorservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suppliersRelationalDb") /* suppliersRelationalDb -> proveedores */
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length = 11, unique = true)
    private String ruc;
    @Column(nullable=false, unique = true)
    private String razonSocial;
    @Column(nullable=false)
    private String direccion;
    @Column(nullable=false, length = 50)
    private String distrito;
    @Column(nullable=false, length = 9)
    private String telefono;
    @Column(nullable=false, length = 100, unique = true)
    private String correo;
    @Column(nullable=false, length = 150, unique = true)
    private String paginaWeb;

    /* Add new attribute to make a relational DB between Customers -> Products */
    private Integer productId;

}
