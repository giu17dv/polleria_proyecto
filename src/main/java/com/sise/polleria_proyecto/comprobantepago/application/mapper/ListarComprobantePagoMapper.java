package com.sise.polleria_proyecto.comprobantepago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.comprobantepago.application.dto.request.ListarComprobantePagoRequestDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.ListarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.domain.entity.ComprobantePago;

@Component
public class ListarComprobantePagoMapper implements IEntityDtoMapper<ComprobantePago, ListarComprobantePagoRequestDto, ListarComprobantePagoResponseDto> {

    @Override
    public ComprobantePago requestToEntity(ListarComprobantePagoRequestDto dto) {
        // Si el request de listar no tiene filtros, devolvemos un comprobante vacío
        return new ComprobantePago();
    }

    @Override
    public ListarComprobantePagoResponseDto entityToResponse(ComprobantePago entity) {
        ListarComprobantePagoResponseDto responseDto = new ListarComprobantePagoResponseDto();
        responseDto.setIdComprobantePago(entity.getIdComprobantePago());
        responseDto.setIdPedido(entity.getIdPedido());
        responseDto.setTipo(entity.getTipo());
        
        responseDto.setMontoTotal(entity.getMontoTotal());
        
        responseDto.setFechaEmision(entity.getFechaEmision());
        
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        responseDto.setFechaModificacion(entity.getFechaModificacion());
        return responseDto;
    }
}
