package com.sise.polleria_proyecto.rol.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta de la eliminación exitosa (cambio de estado a inactivo) de un rol.")
public class EliminarRolResponseDto {

    @Schema(description = "Identificador único del rol afectado por la operación.", example = "10")
    private Integer idRol;

    @Schema(description = "Nombre del rol afectado.", example = "ADMINISTRADOR")
    private String nombre;

    @Schema(description = "Estado final del rol tras la operación (debe ser 'INACTIVO' o 'ELIMINADO').", example = "INACTIVO")
    private String estado;

    @Schema(description = "Mensaje de confirmación.", example = "El rol ha sido marcado como inactivo.")
    private String mensajeConfirmacion;
}
