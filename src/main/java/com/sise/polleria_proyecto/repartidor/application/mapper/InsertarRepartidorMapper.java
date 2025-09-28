package com.sise.polleria_proyecto.repartidor.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.repartidor.application.dto.request.InsertarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.InsertarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.domain.entity.Repartidor;

@Component
public class InsertarRepartidorMapper implements IEntityDtoMapper<Repartidor, InsertarRepartidorRequestDto, InsertarRepartidorResponseDto> {

    @Override
    public Repartidor requestToEntity(InsertarRepartidorRequestDto requestDto) {
        Repartidor repartidor = new Repartidor();
        repartidor.setNombre(requestDto.getNombre());
        repartidor.setTelefono(requestDto.getTelefono());
        repartidor.setDisponible(requestDto.getDisponible());
        return repartidor;
    }

    @Override
    public InsertarRepartidorResponseDto entityToResponse(Repartidor entity) {
        InsertarRepartidorResponseDto responseDto = new InsertarRepartidorResponseDto();
        responseDto.setIdRepartidor(entity.getIdRepartidor());
        responseDto.setNombre(entity.getNombre());
        responseDto.setTelefono(entity.getTelefono());
        responseDto.setDisponible(entity.getDisponible());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        
        return responseDto;
    }
}
