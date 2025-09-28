package com.sise.polleria_proyecto.repartidor.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.repartidor.application.dto.request.EditarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.EditarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.domain.entity.Repartidor;

import java.time.LocalDateTime;

@Component
public class EditarRepartidorMapper implements IEntityDtoMapper<Repartidor, EditarRepartidorRequestDto, EditarRepartidorResponseDto> {

    @Override
    public Repartidor requestToEntity(EditarRepartidorRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Repartidor entity = new Repartidor();
        entity.setIdRepartidor(dto.getIdRepartidor());
        entity.setNombre(dto.getNombre());
        entity.setTelefono(dto.getTelefono());
        entity.setDisponible(dto.getDisponible());
        entity.setFechaModificacion(LocalDateTime.now().toString());

        return entity;
    }

    @Override
    public EditarRepartidorResponseDto entityToResponse(Repartidor entity) {
        if (entity == null) {
            return null;
        }

        EditarRepartidorResponseDto dto = new EditarRepartidorResponseDto();
        dto.setIdRepartidor(entity.getIdRepartidor());
        dto.setNombre(entity.getNombre());
        dto.setTelefono(entity.getTelefono());
        dto.setDisponible(entity.getDisponible());
        dto.setFechaModificacion(entity.getFechaModificacion());

        return dto;
    }
}
