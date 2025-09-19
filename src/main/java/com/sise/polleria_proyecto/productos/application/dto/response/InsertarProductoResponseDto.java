package com.sise.polleria_proyecto.productos.application.dto.response;


import java.time.LocalDateTime;
import lombok.Data;

@Data

public class InsertarProductoResponseDto {
    

    
    private String nombre_producto;

    
    private String descripcion;

    
    private Double precio;

    
    private String tipo;

    
    private LocalDateTime fecha_creacion;

    
    


}
