package com.sise.polleria_proyecto.Usuario.Application.dto.response;
 


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
 
@Data
@Schema(description = "Respuesta de la creación exitosa de un usuario.")
public class InsertarUsuarioResponseDto {
   
 
    @Schema(description = "Identificador único del usuario creado.", example = "105")
    private Integer idUsuario;
 
    @Schema(description = "Nombre completo del usuario.", example = "Juan Pérez")
    private String nombreCompleto;
 
    @Schema(description = "Correo electrónico del usuario.", example = "juan.perez@polleria.com")
    private String email;
 
    @Schema(description = "Rol asignado al usuario.", example = "EMPLEADO")
    private String rol;
   
    @Schema(description = "Fecha y hora en que fue creado el registro.", example = "2025-09-27T10:30:00Z")
    private String fechaCreacion;
}
