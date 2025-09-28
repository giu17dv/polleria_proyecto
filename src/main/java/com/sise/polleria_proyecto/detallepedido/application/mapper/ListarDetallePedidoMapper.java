package com.sise.polleria_proyecto.detallepedido.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.ListarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.ListarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.domain.entities.DetallePedido;

@Component
public class ListarDetallePedidoMapper implements IEntityDtoMapper<DetallePedido, ListarDetallePedidoRequestDto, ListarDetallePedidoResponseDto> {
    
    @Override
    public DetallePedido requestToEntity(ListarDetallePedidoRequestDto dto) {
        // Since ListarDetallePedidoRequestDto is empty, we return a new DetallePedido instance
        return new DetallePedido();
    }

    @Override
    public ListarDetallePedidoResponseDto entityToResponse(DetallePedido entity) {
        ListarDetallePedidoResponseDto responseDto = new ListarDetallePedidoResponseDto();
        responseDto.setIdDetallePedido(entity.getIdDetallePedido());
        responseDto.setIdPedido(entity.getIdPedido());
        responseDto.setIdProducto(entity.getIdProducto());
        responseDto.setCantidad(entity.getCantidad());
        responseDto.setPrecioUnitario(entity.getPrecioUnitario());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
            responseDto.setFechaModificacion(entity.getFechaModificacion());
        
        return responseDto;
    }
    
}
