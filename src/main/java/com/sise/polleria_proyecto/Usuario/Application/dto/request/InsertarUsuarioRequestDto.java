package com.sise.polleria_proyecto.Usuario.Application.dto.request;
 
// Importaciones necesarias de Swagger y Validación
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
 
@Data
@Schema(description = "Datos necesarios para registrar un nuevo usuario en el sistema.")
public class InsertarUsuarioRequestDto {
 
    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre(s) del nuevo usuario.", example = "Juan")
    private String nombre;
 
    @NotBlank(message = "El apellido es obligatorio")
    @Schema(description = "Apellido(s) del nuevo usuario.", example = "Pérez García")
    private String apellido;
 
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un formato de email válido")
    @Schema(description = "Correo electrónico único para inicio de sesión.", example = "juan.perez@polleria.com")
    private String email;
 
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "Debe tener al menos 6 caracteres")
    @Schema(description = "Contraseña para el nuevo usuario.", example = "MiClaveSegura123")
    private String contrasena;
 
    @Schema(description = "Número de teléfono del usuario.", example = "987654321")
    private String telefono;
 
    @Schema(description = "Dirección de residencia o contacto.", example = "Av. Las Flores 123, San Borja")
    private String direccion;
 
    @NotBlank(message = "El rol es obligatorio")
    @Schema(description = "Rol o perfil del usuario (ej: ADMINISTRADOR, EMPLEADO, CLIENTE).", example = "EMPLEADO")
    private String rol;
}