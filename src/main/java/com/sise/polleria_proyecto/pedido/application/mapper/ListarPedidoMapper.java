package com.sise.polleria_proyecto.pedido.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.pedido.application.dto.request.ListarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.ListarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.domain.entities.Pedido;

@Component
public class ListarPedidoMapper implements IEntityDtoMapper<Pedido, ListarPedidoRequestDto, ListarPedidoResponseDto>   {
    

     @Override
    public Pedido requestToEntity(ListarPedidoRequestDto requestDto) {
        // Since ListarPedidoRequestDto is empty, we return a new Pedido instance
        return new Pedido();
    }

    @Override
    public ListarPedidoResponseDto entityToResponse(Pedido entity) {
        ListarPedidoResponseDto responseDto = new ListarPedidoResponseDto();
        responseDto.setIdPedido(entity.getIdPedido());
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setEstado(entity.getEstado());
        responseDto.setTotal(entity.getTotal());
        return responseDto;
    }
    
}
