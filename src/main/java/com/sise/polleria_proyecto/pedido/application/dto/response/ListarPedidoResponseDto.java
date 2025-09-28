package com.sise.polleria_proyecto.pedido.application.dto.response;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO de respuesta para listar pedidos.")
public class ListarPedidoResponseDto {

    @Schema(description = "Identificador único del pedido.", example = "101")
    private Integer idPedido;

    @Schema(description = "ID del usuario que realizó el pedido.", example = "12")
    private Integer idUsuario;

    @Schema(description = "Fecha y hora en que se realizó el pedido.", example = "2025-09-27T18:30:00")
    private LocalDateTime fechaHoraPedido;

    @Schema(description = "Estado actual del pedido.", example = "PENDIENTE")
    private String estado;

    @Schema(description = "Monto total del pedido.", example = "120.50")
    private Double total;

    @Schema(description = "Fecha de creación del registro.", example = "2025-09-27T18:31:00")
    private LocalDateTime fechaCreacion;

    @Schema(description = "Última fecha de modificación del pedido.", example = "2025-09-27T19:00:00")
    private LocalDateTime fechaModificacion;
}
