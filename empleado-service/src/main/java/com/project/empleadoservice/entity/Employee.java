package com.project.empleadoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empleados")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 8, unique = true)
    private String dni;
    @Column(nullable = false, length = 90)
    private String nombre;
    @Column(nullable = false, length = 200)
    private String direccion;
    @Column(nullable = false)
    private Integer edad;
    @Column(nullable = false, length = 9)
    private String celular;
    @Column(nullable = false, length = 100, unique = true)
    private String correo;
    @Column(nullable = false, length = 1)
    private String sexo;
    @Column(nullable = false, length = 90)
    private String cargo;
    @Column(nullable = false)
    private Double sueldo;
}
