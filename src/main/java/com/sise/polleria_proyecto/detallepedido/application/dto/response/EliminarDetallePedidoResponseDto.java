package com.sise.polleria_proyecto.detallepedido.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta de la eliminación de un detalle de pedido.")
public class EliminarDetallePedidoResponseDto {

    @Schema(description = "Identificador único del detalle de pedido eliminado.", example = "201")
    private Integer idDetallePedido;

    @Schema(description = "Mensaje de confirmación de eliminación.", example = "Detalle de pedido eliminado correctamente.")
    private String mensajeConfirmacion;
}
