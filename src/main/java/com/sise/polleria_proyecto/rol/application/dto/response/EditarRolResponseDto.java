package com.sise.polleria_proyecto.rol.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta que devuelve los datos del rol después de ser editado.")
public class EditarRolResponseDto {

    @Schema(description = "Identificador único del rol actualizado.", example = "10")
    private Integer idRol;

    @Schema(description = "Nombre del rol actualizado.", example = "ADMINISTRADOR")
    private String nombre;

    @Schema(description = "Descripción del rol actualizado.", example = "Acceso total al sistema", nullable = true)
    private String descripcion;

    @Schema(description = "Indica la fecha y hora de la última modificación.", example = "2025-09-27T17:35:00Z")
    private String fechaModificacion;
}
