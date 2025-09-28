package com.sise.polleria_proyecto.detallepedido.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.EliminarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.EliminarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.domain.entities.DetallePedido;

@Component
public class EliminarDetallePedidoMapper implements IEntityDtoMapper <DetallePedido, EliminarDetallePedidoRequestDto, EliminarDetallePedidoResponseDto> {

    @Override
    public DetallePedido requestToEntity(EliminarDetallePedidoRequestDto requestDto) {
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setIdDetallePedido(requestDto.getIdDetallePedido());
        return detallePedido;
    }

    @Override
    public EliminarDetallePedidoResponseDto entityToResponse(DetallePedido entity) {
        EliminarDetallePedidoResponseDto responseDto = new EliminarDetallePedidoResponseDto();
        responseDto.setIdDetallePedido(entity.getIdDetallePedido());
        return responseDto;
    }
    
}
