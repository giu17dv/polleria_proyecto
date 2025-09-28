package com.sise.polleria_proyecto.detallepedido.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos necesarios para eliminar un detalle de pedido (lógica).")
public class EliminarDetallePedidoRequestDto {

    @NotNull(message = "El ID del detalle de pedido es obligatorio para la eliminación")
    @Schema(description = "Identificador único del detalle de pedido a eliminar.", example = "201")
    private Integer idDetallePedido;
}
