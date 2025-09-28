package com.sise.polleria_proyecto.comprobantepago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.comprobantepago.application.dto.request.EditarComprobantePagoRequestDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.EditarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.domain.entity.ComprobantePago;

import java.time.LocalDateTime;

@Component
public class EditarComprobantePagoMapper implements IEntityDtoMapper<ComprobantePago, EditarComprobantePagoRequestDto, EditarComprobantePagoResponseDto> {

    @Override
    public ComprobantePago requestToEntity(EditarComprobantePagoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        ComprobantePago entity = new ComprobantePago();
        entity.setIdComprobantePago(dto.getIdComprobantePago());
        entity.setIdUsuario(dto.getIdUsuario());   // Aquí llega un objeto Usuario desde el request
        entity.setIdPedido(dto.getIdPedido());     // Aquí llega un objeto Pedido desde el request
        entity.setTipo(dto.getTipo());
        entity.setMontoTotal(dto.getMontoTotal());
        entity.setFechaModificacion(LocalDateTime.now());

        return entity;
    }

    @Override
    public EditarComprobantePagoResponseDto entityToResponse(ComprobantePago entity) {
        if (entity == null) {
            return null;
        }

        EditarComprobantePagoResponseDto dto = new EditarComprobantePagoResponseDto();
        dto.setIdComprobantePago(entity.getIdComprobantePago());
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setIdPedido(entity.getIdPedido());
        dto.setTipo(entity.getTipo());
        dto.setMontoTotal(entity.getMontoTotal());
        dto.setFechaModificacion(entity.getFechaModificacion());

        return dto;
    }
}
