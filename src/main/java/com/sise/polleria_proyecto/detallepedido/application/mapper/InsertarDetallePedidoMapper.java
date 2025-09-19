package com.sise.polleria_proyecto.detallepedido.application.mapper;

import com.sise.polleria_proyecto.common.application.IEntityDtoMapper;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.InsertarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.InsertarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.domain.entities.DetallePedido;
import org.springframework.stereotype.Component;

@Component
public class InsertarDetallePedidoMapper implements IEntityDtoMapper<DetallePedido, InsertarDetallePedidoRequestDto, InsertarDetallePedidoResponseDto> {

    @Override
    public DetallePedido requestToEntity(InsertarDetallePedidoRequestDto requestDto) {
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setIdPedido(requestDto.getIdPedido());
        detallePedido.setIdProducto(requestDto.getIdProducto());
        detallePedido.setCantidad(requestDto.getCantidad());
        detallePedido.setPrecioUnitario(requestDto.getPrecioUnitario());
        return detallePedido;
    }

    @Override
    public InsertarDetallePedidoResponseDto entityToResponse(DetallePedido entity) {
        InsertarDetallePedidoResponseDto responseDto = new InsertarDetallePedidoResponseDto();
        responseDto.setIdPedido(entity.getIdPedido());
        responseDto.setIdProducto(entity.getIdProducto());
        responseDto.setCantidad(entity.getCantidad());
        responseDto.setPrecioUnitario(entity.getPrecioUnitario());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
    
}
