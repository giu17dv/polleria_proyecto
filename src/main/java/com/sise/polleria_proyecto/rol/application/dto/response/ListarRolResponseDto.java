package com.sise.polleria_proyecto.rol.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Modelo de datos de un rol devuelto en la lista de consulta.")
public class ListarRolResponseDto {

    @Schema(description = "Identificador único del rol.", example = "10")
    private Integer idRol;

    @Schema(description = "Nombre del rol.", example = "ADMINISTRADOR")
    private String nombre;

    @Schema(description = "Descripción del rol.", example = "Acceso total al sistema", nullable = true)
    private String descripcion;

    @Schema(description = "Estado actual del rol (ACTIVO/INACTIVO).", example = "ACTIVO")
    private String estado;

    @Schema(description = "Fecha y hora de creación del registro.", example = "2025-09-27T10:30:00Z")
    private String fechaCreacion;

    @Schema(description = "Fecha y hora de la última modificación del registro.", example = "2025-09-27T17:35:00Z", nullable = true)
    private String fechaModificacion;
}

