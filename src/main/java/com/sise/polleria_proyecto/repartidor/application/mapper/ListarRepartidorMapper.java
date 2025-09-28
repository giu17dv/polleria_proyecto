package com.sise.polleria_proyecto.repartidor.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.repartidor.application.dto.request.ListarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.ListarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.domain.entity.Repartidor;

@Component
public class ListarRepartidorMapper implements IEntityDtoMapper<Repartidor, ListarRepartidorRequestDto, ListarRepartidorResponseDto> {

    @Override
    public Repartidor requestToEntity(ListarRepartidorRequestDto dto) {
        // Si el request de listar no tiene filtros específicos, devolvemos un repartidor vacío
        return new Repartidor();
    }

    @Override
    public ListarRepartidorResponseDto entityToResponse(Repartidor entity) {
        ListarRepartidorResponseDto responseDto = new ListarRepartidorResponseDto();
        responseDto.setIdRepartidor(entity.getIdRepartidor());
        responseDto.setNombre(entity.getNombre());
        responseDto.setTelefono(entity.getTelefono());
        responseDto.setDisponible(entity.getDisponible());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        responseDto.setFechaModificacion(entity.getFechaModificacion());
        return responseDto;
    }
}
