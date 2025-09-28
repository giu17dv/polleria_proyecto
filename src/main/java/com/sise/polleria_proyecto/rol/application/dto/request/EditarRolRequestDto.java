package com.sise.polleria_proyecto.rol.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos para actualizar la información de un rol existente.")
public class EditarRolRequestDto {

    @NotNull(message = "El ID del rol es obligatorio para la edición")
    @Schema(description = "Identificador único del rol a editar.", example = "10")
    private Integer idRol;

    @Schema(description = "Nuevo nombre del rol (Opcional).", example = "ADMINISTRADOR", nullable = true)
    private String nombre;

    @Schema(description = "Nueva descripción del rol (Opcional).", example = "Acceso total al sistema", nullable = true)
    private String descripcion;
}
