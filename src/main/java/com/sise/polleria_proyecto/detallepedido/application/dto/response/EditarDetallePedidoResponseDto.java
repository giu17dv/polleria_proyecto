package com.sise.polleria_proyecto.detallepedido.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta de la edición de un detalle de pedido.")
public class EditarDetallePedidoResponseDto {

    @Schema(description = "Identificador único del detalle de pedido editado.", example = "201")
    private Integer idDetallePedido;

    @Schema (description = "Identificador del pedido asociado.", example = "1001")
    private Integer idPedido;

    @Schema(description = "Identificador del producto asociado.", example = "301")
    private Integer idProducto;

    @Schema(description = "Cantidad actualizada.", example = "5")
    private Integer cantidad;


    @Schema(description = "Precio unitario actualizado.", example = "27.00")
    private Double precioUnitario;

    

    @Schema(description = "Fecha de última modificación.", example = "2025-09-27T17:35:00Z")
    private String fechaModificacion;
}
