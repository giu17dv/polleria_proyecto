package com.sise.polleria_proyecto.rol.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Datos necesarios para crear un nuevo rol en el sistema.")
public class InsertarRolRequestDto {

    @NotBlank(message = "El nombre del rol es obligatorio")
    @Schema(description = "Nombre del nuevo rol.", example = "ADMINISTRADOR")
    private String nombre;

    @Schema(description = "Descripción opcional del rol.", example = "Acceso total al sistema", nullable = true)
    private String descripcion;
}

