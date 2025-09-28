package com.sise.polleria_proyecto.pedido.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.pedido.application.dto.request.InsertarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.InsertarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.domain.entities.Pedido;

@Component
public class InsertarPedidoMapper implements IEntityDtoMapper<Pedido, InsertarPedidoRequestDto, InsertarPedidoResponseDto> {

    

    @Override
    public Pedido requestToEntity(InsertarPedidoRequestDto requestDto) {
        Pedido pedido = new Pedido();
        
        
        pedido.setIdUsuario(requestDto.getIdUsuario()); // requestDto.getIdUsuario() returns Integer
        
        pedido.setEstado(requestDto.getEstado());
        pedido.setTotal(requestDto.getTotal());
        return pedido;
    }

    @Override
    public InsertarPedidoResponseDto entityToResponse(Pedido entity) {
        InsertarPedidoResponseDto responseDto = new InsertarPedidoResponseDto();
        
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setFechaHoraPedido(entity.getFechaHoraPedido());
        responseDto.setEstado(entity.getEstado());
        responseDto.setTotal(entity.getTotal());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
    
}
