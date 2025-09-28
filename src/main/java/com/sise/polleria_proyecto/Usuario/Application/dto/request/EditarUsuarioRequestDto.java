package com.sise.polleria_proyecto.Usuario.Application.dto.request;
 
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
 
@Data
@Schema(description = "Datos para actualizar la información de un usuario existente.")
public class EditarUsuarioRequestDto {
   
    @NotNull(message = "El ID del usuario es obligatorio para la edición")
    @Schema(description = "Identificador único del usuario a editar.", example = "105")
    private Integer idUsuario;
 
    @Schema(description = "Nuevo nombre(s) del usuario (Opcional).", example = "Juan Carlos", nullable = true)
    private String nombre;
   
    @Schema(description = "Nuevo apellido(s) del usuario (Opcional).", example = "García", nullable = true)
    private String apellido;
   
    @Schema(description = "Nuevo correo electrónico del usuario (Opcional).", example = "juan.carlos@polleria.com", nullable = true)
    private String email;
   
    @Schema(description = "Nuevo número de teléfono (Opcional).", example = "998877665", nullable = true)
    private String telefono;

    @Schema(description = "Nuevo estado del usuario '(Opcional).", example = "ACTIVO", nullable = true)
    private String estado;
   
    @Schema(description = "Nueva dirección (Opcional).", example = "Calle Los Robles 456", nullable = true)
    private String direccion;
   
    @Schema(description = "Nueva contraseña (Opcional, se recomienda un endpoint aparte para esto).", nullable = true)
    private String contrasena;
   
    @Schema(description = "Nuevo rol del usuario (Opcional).", example = "ADMINISTRADOR", nullable = true)
    private String rol;
   
}
