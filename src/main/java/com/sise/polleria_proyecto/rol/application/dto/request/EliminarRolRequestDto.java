package com.sise.polleria_proyecto.rol.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos necesarios para la eliminación lógica de un rol por su ID.")
public class EliminarRolRequestDto {

    @NotNull(message = "El ID del rol es obligatorio para la eliminación")
    @Schema(description = "Identificador único del rol a eliminar.", example = "10")
    private Integer idRol;

    @Schema(description = "Nuevo estado del rol (por ejemplo, 'INACTIVO' o 'ELIMINADO').", example = "INACTIVO", nullable = true)
    private String estado;
}
