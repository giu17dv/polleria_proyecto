package com.sise.polleria_proyecto.repartidor.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta de la eliminación exitosa (cambio de estado a inactivo) de un repartidor.")
public class EliminarRepartidorResponseDto {

    @Schema(description = "Identificador único del repartidor afectado por la operación.", example = "105")
    private Integer idRepartidor;

    @Schema(description = "Nombre completo del repartidor afectado.", example = "Carlos Pérez")
    private String nombreRepartidor;

    @Schema(description = "Estado final del registro tras la operación (debe ser 'INACTIVO' o 'ELIMINADO').", example = "INACTIVO")
    private String estado;

    @Schema(description = "Mensaje de confirmación.", example = "El repartidor ha sido marcado como inactivo.")
    private String mensajeConfirmacion;
}
