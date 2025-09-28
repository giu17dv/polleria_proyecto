package com.sise.polleria_proyecto.productos.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO de solicitud para editar un producto existente.")
public class EditarProductoRequestDto {

    @Schema(description = "ID único del producto a editar.", example = "10")
    private Integer idProducto;

    @Schema(description = "Nuevo nombre del producto.", example = "Pollo Broaster")
    private String nombreProducto;

    @Schema(description = "Nueva descripción del producto.", example = "Pollo frito crocante con papas y ensalada.")
    private String descripcion;

    @Schema(description = "Nuevo precio del producto.", example = "35.50")
    private Double precio;

    @Schema(description = "Nuevo tipo de producto.", example = "COMIDA")
    private String tipo;
}
