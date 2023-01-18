package com.project.clienteservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customersRelationalDb") /* customersRelationalDb -> clients */
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 8, unique = true)
    private String dni;
    @Column(nullable = false, length = 70)
    private String nombre;
    @Column(nullable = false, length = 150)
    private String distrito;
    @Column(nullable = false)
    private Integer edad;
    @Column(nullable = false, length = 9)
    private String celular;
    @Column(nullable = false, length = 90, unique = true)
    private String correo;
    @Column(nullable = false, length = 1)
    private String sexo;

    /* Add new attribute to make a relational DB between Customers -> Products */
    private Integer productId;
}
