package com.sise.polleria_proyecto.productos.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO de respuesta para listar productos.")
public class ListarProductoResponseDto {

    @Schema(description = "ID único del producto.", example = "10")
    private Integer idProducto;

    @Schema(description = "Nombre del producto.", example = "Pollo a la Brasa")
    private String nombreProducto;

    @Schema(description = "Descripción del producto.", example = "Pollo entero acompañado de papas fritas y ensalada.")
    private String descripcion;

    @Schema(description = "Precio del producto.", example = "49.90")
    private Double precio;

    @Schema(description = "Tipo de producto.", example = "COMIDA")
    private String tipo;

    @Schema(description = "Fecha de creación.", example = "2025-09-27T12:30:00Z")
    private String fechaCreacion;

    @Schema(description = "Fecha de última modificación.", example = "2025-09-27T15:45:00Z", nullable = true)
    private String fechaModificacion;
}
