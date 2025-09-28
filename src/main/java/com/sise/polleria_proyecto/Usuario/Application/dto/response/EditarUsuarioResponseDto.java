package com.sise.polleria_proyecto.Usuario.Application.dto.response;
 


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
 
@Data
@Schema(description = "Respuesta que devuelve los datos del usuario después de ser editado.")
public class EditarUsuarioResponseDto {
   
    @Schema(description = "Identificador único del usuario actualizado.", example = "105")
    private Integer idUsuario;
 
    @Schema(description = "Nombre completo resultante después de la edición.", example = "Juan Carlos García")
    private String nombreCompleto;
 
    @Schema(description = "Correo electrónico actualizado.", example = "juan.carlos@polleria.com")
    private String email;
 
    @Schema(description = "Rol actual del usuario.", example = "ADMINISTRADOR")
    private String rol;

    @Schema(description = "Estado actual del usuario.", example = "ACTIVO")
    private String estado;
   
    @Schema(description = "Indica la fecha y hora de la última modificación.", example = "2025-09-27T17:35:00Z")
    private String fechaModificacion;
}