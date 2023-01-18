package com.project.productoservice.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String distrito;
    private String telefono;
    private String correo;
    private String paginaWeb;

    /*Add Ja17*/
    private Integer productId;
}
