package com.sise.polleria_proyecto.pedido.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "DTO para eliminar un pedido por su ID.")
public class EliminarPedidoRequestDto {

    @NotNull(message = "El ID del pedido es obligatorio para eliminar")
    @Schema(description = "Identificador único del pedido a eliminar.", example = "101")
    private Integer idPedido;
}
