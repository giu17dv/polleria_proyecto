package com.sise.polleria_proyecto.repartidor.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.repartidor.application.dto.request.EliminarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.EliminarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.domain.entity.Repartidor;

@Component
public class EliminarRepartidorMapper implements IEntityDtoMapper<Repartidor, EliminarRepartidorRequestDto, EliminarRepartidorResponseDto> {

    @Override
    public Repartidor requestToEntity(EliminarRepartidorRequestDto requestDto) {
        Repartidor repartidor = new Repartidor();
        repartidor.setIdRepartidor(requestDto.getIdRepartidor());
        return repartidor;
    }

    @Override
    public EliminarRepartidorResponseDto entityToResponse(Repartidor entity) {
        EliminarRepartidorResponseDto responseDto = new EliminarRepartidorResponseDto();
        responseDto.setIdRepartidor(entity.getIdRepartidor());
        return responseDto;
    }
}
