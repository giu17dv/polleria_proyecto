package com.sise.polleria_proyecto.productos.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO de respuesta al registrar un nuevo producto.")
public class InsertarProductoResponseDto {

    @Schema(description = "ID único del producto.", example = "10")
    private Integer idProducto;

    @Schema(description = "Nombre del producto registrado.", example = "Pollo a la Brasa")
    private String nombreProducto;

    @Schema(description = "Descripción del producto.", example = "Pollo a la brasa con papas y ensalada.")
    private String descripcion;

    @Schema(description = "Precio del producto.", example = "30.50")
    private Double precio;

    @Schema(description = "Tipo de producto.", example = "COMIDA")
    private String tipo;

    @Schema(description = "Mensaje de confirmación.", example = "Producto registrado exitosamente.")
    private String mensaje;

    @Schema(description = "Fecha de creación del registro.", example = "2025-09-27T10:30:00Z")
    private String fechaCreacion;
}

