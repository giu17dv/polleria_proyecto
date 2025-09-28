package com.sise.polleria_proyecto.Usuario.Application.dto.request;
 
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
 
@Data
@Schema(description = "Datos necesarios para la eliminación lógica de un usuario por su ID.")
public class EliminarUsuarioRequestDto {
 
    @NotNull(message = "El ID del usuario es obligatorio para la eliminación")
    @Schema(description = "Identificador único del usuario a eliminar.", example = "105")
    private Integer idUsuario;

    @Schema(description = "Nuevo estado del usuario (debe ser 'INACTIVO' o 'ELIMINADO').", example = "INACTIVO")
    private String estado;
   
}