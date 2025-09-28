package com.sise.polleria_proyecto.pedido.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta después de eliminar un pedido.")
public class EliminarPedidoResponseDto {

    @Schema(description = "ID del pedido eliminado.", example = "101")
    private Integer idPedido;

    @Schema(description = "Mensaje de confirmación de la eliminación.", example = "Pedido eliminado correctamente.")
    private String mensaje;
}
