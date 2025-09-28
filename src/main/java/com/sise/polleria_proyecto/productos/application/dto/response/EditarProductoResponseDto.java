package com.sise.polleria_proyecto.productos.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO de respuesta al editar un producto.")
public class EditarProductoResponseDto {

    @Schema(description = "ID del producto editado.", example = "10")
    private Integer idProducto;

    @Schema(description = "Nombre actualizado del producto.", example = "Pollo Broaster")
    private String nombreProducto;

    @Schema(description = "Descripción actualizada del producto.", example = "Pollo frito crocante con papas y ensalada.")
    private String descripcion;

    @Schema(description = "Precio actualizado del producto.", example = "35.50")
    private Double precio;

    @Schema(description = "Tipo actualizado del producto.", example = "COMIDA")
    private String tipo;

    @Schema(description = "Mensaje de confirmación.", example = "Producto actualizado correctamente.")
    private String mensaje;

    @Schema(description = "Fecha de última modificación del registro.", example = "2025-09-27T14:00:00Z")
    private String fechaModificacion;
}
