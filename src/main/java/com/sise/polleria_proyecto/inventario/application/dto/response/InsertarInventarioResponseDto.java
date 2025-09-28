package com.sise.polleria_proyecto.inventario.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta después de insertar un inventario.")
public class InsertarInventarioResponseDto {

    @Schema(description = "Identificador único del inventario insertado.", example = "101")
    private Integer idInventario;

    @Schema(description = "Identificador del producto asociado al inventario.", example = "202")
    private Integer idProducto;

    @Schema(description = "Cantidad de productos en el inventario.", example = "50")
    private Integer cantidad;

    @Schema(description = "Stock mínimo requerido para el inventario.", example = "10")
    private Integer stockMinimo;

    @Schema(description = "Ubicación física del inventario.", example = "Almacén A - Estante 3")
    private String ubicacion;

    @Schema(description = "Fecha de creación del inventario en formato ISO 8601.", example = "2024-10-05T14:48:00Z")
    private String fechaCreacion;

    @Schema(description = "Mensaje de confirmación.", example = "Inventario insertado exitosamente.")
    private String mensaje;
}
