package com.sise.polleria_proyecto.comprobantepago.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.comprobantepago.application.dto.request.EliminarComprobantePagoRequestDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.EliminarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.domain.entity.ComprobantePago;

@Component
public class EliminarComprobantePagoMapper implements IEntityDtoMapper<ComprobantePago, EliminarComprobantePagoRequestDto, EliminarComprobantePagoResponseDto> {

    @Override
    public ComprobantePago requestToEntity(EliminarComprobantePagoRequestDto requestDto) {
        ComprobantePago comprobante = new ComprobantePago();
        comprobante.setIdComprobantePago(requestDto.getIdComprobantePago());
        return comprobante;
    }

    @Override
    public EliminarComprobantePagoResponseDto entityToResponse(ComprobantePago entity) {
        EliminarComprobantePagoResponseDto responseDto = new EliminarComprobantePagoResponseDto();
        responseDto.setIdComprobantePago(entity.getIdComprobantePago());
        return responseDto;
    }
}
