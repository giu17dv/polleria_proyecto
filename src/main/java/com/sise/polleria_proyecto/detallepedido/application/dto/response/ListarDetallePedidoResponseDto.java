package com.sise.polleria_proyecto.detallepedido.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Modelo de datos de un detalle de pedido devuelto en la lista de consulta.")
public class ListarDetallePedidoResponseDto {

    @Schema(description = "Identificador único del detalle de pedido.", example = "201")
    private Integer idDetallePedido;

    @Schema(description = "ID del pedido asociado.", example = "101")
    private Integer idPedido;

    @Schema(description = "ID del producto asociado.", example = "55")
    private Integer idProducto;

    @Schema(description = "Cantidad de productos.", example = "3")
    private Integer cantidad;

    @Schema(description = "Precio unitario del producto.", example = "25.50")
    private Double precioUnitario;

    @Schema(description = "Fecha de creación del registro.", example = "2025-09-27T10:30:00Z")
    private String fechaCreacion;

    @Schema(description = "Fecha de última modificación del registro.", example = "2025-09-27T17:35:00Z", nullable = true)
    private String fechaModificacion;
}
