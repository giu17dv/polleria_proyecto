package com.sise.polleria_proyecto.productos.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO de respuesta al eliminar un producto.")
public class EliminarProductoResponseDto {

    @Schema(description = "ID del producto eliminado.", example = "10")
    private Integer idProducto;

    @Schema(description = "Mensaje de confirmación.", example = "Producto eliminado exitosamente.")
    private String mensaje;
}
