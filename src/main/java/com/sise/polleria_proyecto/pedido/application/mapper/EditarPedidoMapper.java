package com.sise.polleria_proyecto.pedido.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.pedido.application.dto.request.EditarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.EditarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.domain.entities.Pedido;

@Component
public class EditarPedidoMapper implements IEntityDtoMapper<Pedido,EditarPedidoRequestDto, EditarPedidoResponseDto>   {
    

    @Override
    public Pedido requestToEntity(EditarPedidoRequestDto requestDto) {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(requestDto.getIdPedido());
        pedido.setIdUsuario(requestDto.getIdUsuario());
        pedido.setEstado(requestDto.getEstado());
        pedido.setTotal(requestDto.getTotal());
        return pedido;
    }

    @Override
    public EditarPedidoResponseDto entityToResponse(Pedido entity) {
        EditarPedidoResponseDto responseDto = new EditarPedidoResponseDto();
        responseDto.setIdPedido(entity.getIdPedido());
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setEstado(entity.getEstado());
        responseDto.setTotal(entity.getTotal());
        return responseDto;
    }

}
