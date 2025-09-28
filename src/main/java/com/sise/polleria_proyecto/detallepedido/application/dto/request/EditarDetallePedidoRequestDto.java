package com.sise.polleria_proyecto.detallepedido.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos para actualizar un detalle de pedido existente.")
public class EditarDetallePedidoRequestDto {

    @NotNull(message = "El ID del detalle de pedido es obligatorio para la edición")
    @Schema(description = "Identificador único del detalle de pedido a editar.", example = "201")
    private Integer idDetallePedido;

    @Schema(description = "Identificador del pedido asociado (No editable).", example = "1001", nullable = true)
    private Integer idPedido;

    @Schema(description = "Identificador del producto asociado (No editable).", example = "301", nullable = true)
    private Integer idProducto;

    @Schema(description = "Nueva cantidad de productos (Opcional).", example = "5", nullable = true)
    private Integer cantidad;

    @Schema(description = "Nuevo precio unitario (Opcional).", example = "27.00", nullable = true)
    private Double precioUnitario;
}
