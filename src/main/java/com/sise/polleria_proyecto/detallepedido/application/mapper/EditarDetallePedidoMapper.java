package com.sise.polleria_proyecto.detallepedido.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.EditarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.EditarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.domain.entities.DetallePedido;

@Component
public class EditarDetallePedidoMapper implements IEntityDtoMapper <DetallePedido, EditarDetallePedidoRequestDto, EditarDetallePedidoResponseDto> {

    @Override
    public DetallePedido requestToEntity(EditarDetallePedidoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setIdDetallePedido(dto.getIdDetallePedido());
        detallePedido.setIdPedido(dto.getIdPedido());
        detallePedido.setIdProducto(dto.getIdProducto());
        detallePedido.setCantidad(dto.getCantidad());
        detallePedido.setPrecioUnitario(dto.getPrecioUnitario());
        
        return detallePedido;
    }

    @Override
    public EditarDetallePedidoResponseDto entityToResponse (DetallePedido entity) {
        if (entity == null) {
            return null;
        }

        EditarDetallePedidoResponseDto dto = new EditarDetallePedidoResponseDto();
        dto.setIdDetallePedido(entity.getIdDetallePedido());
        dto.setIdPedido(entity.getIdPedido());
        dto.setIdProducto(entity.getIdProducto());
        dto.setCantidad(entity.getCantidad());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setFechaModificacion(entity.getFechaModificacion());
        
        return dto;
    }
    
}
