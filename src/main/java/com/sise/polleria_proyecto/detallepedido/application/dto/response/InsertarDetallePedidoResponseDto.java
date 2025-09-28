package com.sise.polleria_proyecto.detallepedido.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta de la creación exitosa de un detalle de pedido.")
public class InsertarDetallePedidoResponseDto {

    @Schema(description = "Identificador único del detalle de pedido creado.", example = "201")
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
}
