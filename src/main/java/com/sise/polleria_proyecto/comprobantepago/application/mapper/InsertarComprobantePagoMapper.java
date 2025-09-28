package com.sise.polleria_proyecto.comprobantepago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.comprobantepago.application.dto.request.InsertarComprobantePagoRequestDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.InsertarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.domain.entity.ComprobantePago;

@Component
public class InsertarComprobantePagoMapper implements IEntityDtoMapper<ComprobantePago, InsertarComprobantePagoRequestDto, InsertarComprobantePagoResponseDto> {

    @Override
    public ComprobantePago requestToEntity(InsertarComprobantePagoRequestDto requestDto) {
        ComprobantePago comprobantePago = new ComprobantePago();
        comprobantePago.setIdPedido(requestDto.getIdPedido());
        comprobantePago.setTipo(requestDto.getTipo());
        
        comprobantePago.setMontoTotal(requestDto.getMontoTotal());
        
        return comprobantePago;
    }

    @Override
    public InsertarComprobantePagoResponseDto entityToResponse(ComprobantePago entity) {
        InsertarComprobantePagoResponseDto responseDto = new InsertarComprobantePagoResponseDto();
        responseDto.setIdComprobantePago(entity.getIdComprobantePago());
        responseDto.setIdPedido(entity.getIdPedido());
        responseDto.setTipo(entity.getTipo());
        
        responseDto.setMontoTotal(entity.getMontoTotal());
        responseDto.setFechaEmision(entity.getFechaEmision());
        
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
