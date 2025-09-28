package com.sise.polleria_proyecto.repartidor.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta de la creación exitosa de un repartidor.")
public class InsertarRepartidorResponseDto {

    @Schema(description = "Identificador único del repartidor creado.", example = "105")
    private Integer idRepartidor;

    @Schema(description = "Nombre completo del repartidor.", example = "Carlos Pérez")
    private String nombre;

    @Schema(description = "Número de teléfono del repartidor.", example = "987654321")
    private String telefono;

    @Schema(description = "Disponibilidad actual del repartidor ('SI' o 'NO').", example = "SI")
    private String disponible;

    @Schema(description = "Fecha y hora en que fue creado el registro.", example = "2025-09-27T10:30:00Z")
    private String fechaCreacion;
}
