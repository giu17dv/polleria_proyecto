package com.sise.polleria_proyecto.inventario.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos para eliminar un registro de inventario por su ID.")
public class EliminarInventarioRequestDto {

    @NotNull(message = "El ID del inventario es obligatorio para eliminarlo")
    @Schema(description = "Identificador único del inventario a eliminar.", example = "101")
    private Integer idInventario;
}
