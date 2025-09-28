package com.sise.polleria_proyecto.repartidor.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta que devuelve los datos del repartidor después de ser editado.")
public class EditarRepartidorResponseDto {

    @Schema(description = "Identificador único del repartidor actualizado.", example = "105")
    private Integer idRepartidor;

    @Schema(description = "Nombre completo del repartidor después de la edición.", example = "Carlos Pérez")
    private String nombre;

    @Schema(description = "Número de teléfono actualizado del repartidor.", example = "987654321")
    private String telefono;

    @Schema(description = "Disponibilidad actual del repartidor ('SI' o 'NO').", example = "SI")
    private String disponible;

    @Schema(description = "Indica la fecha y hora de la última modificación.", example = "2025-09-27T17:35:00Z")
    private String fechaModificacion;
}
