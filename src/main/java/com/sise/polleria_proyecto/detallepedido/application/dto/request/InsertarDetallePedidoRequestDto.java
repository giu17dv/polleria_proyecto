package com.sise.polleria_proyecto.detallepedido.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos necesarios para registrar un nuevo detalle de pedido.")
public class InsertarDetallePedidoRequestDto {

    @NotNull(message = "El ID del pedido es obligatorio")
    @Schema(description = "Identificador del pedido al que pertenece este detalle.", example = "101")
    private Integer idPedido;

    @NotNull(message = "El ID del producto es obligatorio")
    @Schema(description = "Identificador del producto.", example = "55")
    private Integer idProducto;

    @NotNull(message = "La cantidad es obligatoria")
    @Schema(description = "Cantidad de productos en este detalle.", example = "3")
    private Integer cantidad;

    @NotNull(message = "El precio unitario es obligatorio")
    @Schema(description = "Precio unitario del producto.", example = "25.50")
    private Double precioUnitario;
}
