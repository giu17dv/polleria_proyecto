package com.sise.polleria_proyecto.repartidor.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos necesarios para la eliminación lógica de un repartidor por su ID.")
public class EliminarRepartidorRequestDto {

    @NotNull(message = "El ID del repartidor es obligatorio para la eliminación")
    @Schema(description = "Identificador único del repartidor a eliminar.", example = "105")
    private Integer idRepartidor;

    @Schema(description = "Nuevo estado del repartidor (debe ser 'INACTIVO' o 'ELIMINADO').", example = "INACTIVO")
    private String estado;
}
