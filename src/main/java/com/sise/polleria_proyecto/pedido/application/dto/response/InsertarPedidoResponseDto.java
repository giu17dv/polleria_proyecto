package com.sise.polleria_proyecto.pedido.application.dto.response;

import java.time.LocalDateTime;


import lombok.Data;

@Data
public class InsertarPedidoResponseDto {
    

    private Integer idUsuario;
    private LocalDateTime fechaHoraPedido;
    
    private String estado;
    private Double total;
    private LocalDateTime fechaCreacion;

    

}
