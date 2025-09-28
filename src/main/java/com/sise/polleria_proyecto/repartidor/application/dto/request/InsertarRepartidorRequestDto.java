package com.sise.polleria_proyecto.repartidor.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Datos necesarios para registrar un nuevo repartidor en el sistema.")
public class InsertarRepartidorRequestDto {

    @NotBlank(message = "El nombre del repartidor es obligatorio")
    @Schema(description = "Nombre del repartidor.", example = "Carlos Pérez")
    private String nombre;

    @Schema(description = "Número de teléfono del repartidor.", example = "987654321")
    private String telefono;

    @NotBlank(message = "El estado de disponibilidad es obligatorio")
    @Schema(description = "Indica si el repartidor está disponible ('SI' o 'NO').", example = "SI")
    private String disponible;
}
