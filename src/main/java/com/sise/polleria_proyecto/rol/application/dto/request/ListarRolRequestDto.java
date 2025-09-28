package com.sise.polleria_proyecto.rol.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Filtros opcionales para listar roles del sistema.")
public class ListarRolRequestDto {

    @Schema(description = "Identificador único del rol (opcional).", example = "10", nullable = true)
    private Integer idRol;

    @Schema(description = "Nombre del rol a filtrar (opcional).", example = "ADMINISTRADOR", nullable = true)
    private String nombre;

    @Schema(description = "Descripción del rol a filtrar (opcional).", example = "Acceso total al sistema", nullable = true)
    private String descripcion;
}
