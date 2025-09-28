package com.sise.polleria_proyecto.inventario.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta después de eliminar un inventario.")
public class EliminarInventarioResponseDto {

    @Schema(description = "Identificador único del inventario eliminado.", example = "101")
    private Integer idInventario;

    @Schema(description = "Mensaje de confirmación.", example = "Inventario eliminado exitosamente.")
    private String mensaje;
}
