package com.sise.polleria_proyecto.repartidor.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Modelo de datos de un repartidor devuelto en la lista de consulta.")
public class ListarRepartidorResponseDto {

    @Schema(description = "Identificador único del repartidor.", example = "105")
    private Integer idRepartidor;

    @Schema(description = "Nombre completo del repartidor.", example = "Carlos Pérez")
    private String nombre;

    @Schema(description = "Número de teléfono del repartidor.", example = "987654321")
    private String telefono;

    @Schema(description = "Disponibilidad actual del repartidor ('SI' o 'NO').", example = "SI")
    private String disponible;

    @Schema(description = "Estado actual del repartidor (ACTIVO/INACTIVO).", example = "ACTIVO")
    private String estado;

    @Schema(description = "Fecha y hora de creación del registro.", example = "2025-09-27T10:30:00Z")
    private String fechaCreacion;

    @Schema(description = "Fecha y hora de la última modificación del registro.", example = "2025-09-27T17:35:00Z", nullable = true)
    private String fechaModificacion;
}
