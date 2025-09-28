package com.sise.polleria_proyecto.pedido.application.dto.response;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta después de crear un nuevo pedido.")
public class InsertarPedidoResponseDto {

    @Schema(description = "Identificador único del pedido recién creado.", example = "101")
    private Integer idPedido;

    @Schema(description = "ID del usuario que realizó el pedido.", example = "12")
    private Integer idUsuario;

    @Schema(description = "Fecha y hora en que se registró el pedido.", example = "2025-09-27T18:30:00")
    private String fechaHoraPedido;

    @Schema(description = "Estado actual del pedido.", example = "PENDIENTE")
    private String estado;

    @Schema(description = "Monto total del pedido.", example = "120.50")
    private Double total;

    @Schema(description = "Fecha de creación del registro.", example = "2025-09-27T18:31:00")
    private String fechaCreacion;
}
