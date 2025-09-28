package com.sise.polleria_proyecto.Usuario.Application.dto.response;
 


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
 
@Data
@Schema(description = "Modelo de datos de un usuario devuelto en la lista de consulta.")
public class ListarUsuarioResponseDto {
 
    @Schema(description = "Identificador único del usuario.", example = "105")
    private Integer idUsuario;
    @Schema(description = "Nombre completo del usuario.", example = "Juan Carlos García")
    private String nombreCompleto;
 
    @Schema(description = "Email de contacto.", example = "juan.carlos@polleria.com")
    private String email;
 
    @Schema(description = "Número de teléfono.", example = "998877665")
    private String telefono;
 
    @Schema(description = "Dirección registrada.", example = "Calle Los Robles 456")
    private String direccion;
 
    @Schema(description = "Rol asignado (ADMINISTRADOR/EMPLEADO/CLIENTE).", example = "EMPLEADO")
    private String rol;
 
 
    @Schema(description = "Estado actual del usuario (ACTIVO/INACTIVO).", example = "ACTIVO")
    private String estado;

    @Schema(description = "Fecha y hora de creación del registro.", example = "2025-09-27T10:30:00Z")
    private String fechaCreacion;

    @Schema(description = "Fecha y hora de la última modificación del registro.", example = "2025-09-27T17:35:00Z", nullable = true)
    private String fechaModificacion;
}