package com.sise.polleria_proyecto.pedido.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.pedido.application.dto.request.EliminarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.EliminarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.domain.entities.Pedido;

@Component
public class EliminarPedidoMapper implements IEntityDtoMapper<Pedido,EliminarPedidoRequestDto, EliminarPedidoResponseDto>   {
    
    @Override
    public Pedido requestToEntity(EliminarPedidoRequestDto requestDto) {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(requestDto.getIdPedido());
        return pedido;
    }

    @Override
    public EliminarPedidoResponseDto entityToResponse(Pedido entity) {
        EliminarPedidoResponseDto responseDto = new EliminarPedidoResponseDto();
        responseDto.setIdPedido(entity.getIdPedido());
        return responseDto;
    }

}
