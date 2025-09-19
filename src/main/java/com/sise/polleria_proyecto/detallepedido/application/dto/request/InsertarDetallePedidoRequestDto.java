package com.sise.polleria_proyecto.detallepedido.application.dto.request;

import lombok.Data;


@Data
public class InsertarDetallePedidoRequestDto {
    

    private Integer idPedido;
    private Integer idProducto;
    private Integer cantidad;
    private Double precioUnitario;

}
