package com.sise.polleria_proyecto.pedido.application.dto.request;





import lombok.Data;


@Data
public class InsertarPedidoRequestDto {
    

    private Integer idUsuario;
    
    private String estado;
    private Double total;


}
