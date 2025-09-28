package com.sise.polleria_proyecto.productos.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO de solicitud para registrar un nuevo producto.")
public class InsertarProductoRequestDto {

    @Schema(description = "Nombre del producto.", example = "Pollo a la Brasa")
    private String nombreProducto;

    @Schema(description = "Descripción del producto.", example = "Pollo entero acompañado de papas fritas y ensalada.")
    private String descripcion;

    @Schema(description = "Precio del producto.", example = "49.90")
    private Double precio;

    @Schema(description = "Tipo de producto.", example = "COMIDA")
    private String tipo;

    @Schema(description = "Fecha de creación del producto en formato ISO 8601.", example = "2025-09-27T10:30:00Z")
    private String fechaCreacion;
}
