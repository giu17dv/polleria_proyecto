package com.sise.polleria_proyecto.detallepedido.application.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class InsertarDetallePedidoResponseDto {
    


    
    private Integer idPedido;
    private Integer idProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private LocalDateTime fechaCreacion;
}
