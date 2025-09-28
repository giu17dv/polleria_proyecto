package com.sise.polleria_proyecto.Usuario.Application.dto.response;
 
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
 
@Data
@Schema(description = "Respuesta de la eliminación exitosa (cambio de estado a inactivo) de un usuario.")
public class EliminarUsuarioResponseDto {
   
    @Schema(description = "Identificador único del usuario afectado por la operación.", example = "105")
    private Integer idUsuario;
 
    @Schema(description = "Nombre completo del usuario afectado.", example = "Juan Carlos García")
    private String nombreUsuario;
 
    @Schema(description = "Estado final del registro tras la operación (debe ser 'INACTIVO' o 'ELIMINADO').", example = "INACTIVO")
    private String estado;
   
    @Schema(description = "Mensaje de confirmación.", example = "El usuario ha sido marcado como inactivo.")
    private String mensajeConfirmacion;
}