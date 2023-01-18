package com.project.productoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productsRelationalDb")  /* productsRelationalDb -> products*/
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 5, unique = true)
    private String codigo;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String marca;
    @Column(nullable = false, length = 50)
    private String modelo;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false, length = 50)
    private String fabricacion;

}
