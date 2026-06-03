package com.practica.practicaweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {

    private Long productoId;
    private String clave;
    private String nombre;
    private Double precio;
    private Long tipoProductoId;
    private String tipoProducto;
    private Integer activo;
}