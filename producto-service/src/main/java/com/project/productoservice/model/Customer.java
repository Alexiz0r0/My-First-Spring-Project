package com.project.productoservice.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String dni;
    private String nombre;
    private String distrito;
    private Integer edad;
    private String celular;
    private String correo;
    private String sexo;

    /*Add Ja17*/
    private Integer productId;
}
