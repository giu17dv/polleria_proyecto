package com.sise.polleria_proyecto.pedido.application.dto.response;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta después de editar un pedido existente.")
public class EditarPedidoResponseDto {

    @Schema(description = "Identificador único del pedido actualizado.", example = "101")
    private Integer idPedido;

    @Schema(description = "ID del usuario asociado al pedido.", example = "12")
    private Integer idUsuario;

    @Schema(description = "Fecha y hora del pedido.", example = "2025-09-27T18:30:00")
    private LocalDateTime fechaHoraPedido;

    @Schema(description = "Estado actualizado del pedido.", example = "EN_PROCESO")
    private String estado;

    @Schema(description = "Monto total actualizado del pedido.", example = "150.00")
    private Double total;

    @Schema(description = "Última fecha de modificación.", example = "2025-09-27T19:00:00")
    private LocalDateTime fechaModificacion;
}
