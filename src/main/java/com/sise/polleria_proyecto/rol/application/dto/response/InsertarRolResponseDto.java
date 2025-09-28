package com.sise.polleria_proyecto.rol.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta de la creación exitosa de un rol.")
public class InsertarRolResponseDto {

    @Schema(description = "Identificador único del rol creado.", example = "10")
    private Integer idRol;

    @Schema(description = "Nombre del rol creado.", example = "ADMINISTRADOR")
    private String nombre;

    @Schema(description = "Descripción del rol creado.", example = "Acceso total al sistema", nullable = true)
    private String descripcion;

    @Schema(description = "Fecha y hora en que fue creado el registro.", example = "2025-09-27T10:30:00Z")
    private String fechaCreacion;
}
