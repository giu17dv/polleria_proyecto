package com.sise.polleria_proyecto.productos.application.dto.request;


import lombok.Data;


@Data
public class InsertarProductoRequestDto {
    

    
    private String nombre_producto;

    
    private String descripcion;

    
    private Double precio;

    
    private String tipo;

}
