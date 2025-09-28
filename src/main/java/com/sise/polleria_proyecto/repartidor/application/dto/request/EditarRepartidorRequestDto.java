package com.sise.polleria_proyecto.repartidor.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos para actualizar la información de un repartidor existente.")
public class EditarRepartidorRequestDto {

    @NotNull(message = "El ID del repartidor es obligatorio para la edición")
    @Schema(description = "Identificador único del repartidor a editar.", example = "105")
    private Integer idRepartidor;

    @Schema(description = "Nuevo nombre del repartidor (Opcional).", example = "Carlos Pérez", nullable = true)
    private String nombre;

    @Schema(description = "Nuevo número de teléfono del repartidor (Opcional).", example = "998877665", nullable = true)
    private String telefono;

    @Schema(description = "Disponibilidad del repartidor (Opcional, valores 'SI' o 'NO').", example = "SI", nullable = true)
    private String disponible;
}

