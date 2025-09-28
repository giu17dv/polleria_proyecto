package com.sise.polleria_proyecto.rol.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.rol.application.dto.request.EditarRolRequestDto;
import com.sise.polleria_proyecto.rol.application.dto.response.EditarRolResponseDto;
import com.sise.polleria_proyecto.rol.domain.entity.Rol;



@Component
public class EditarRolMapper implements IEntityDtoMapper<Rol, EditarRolRequestDto, EditarRolResponseDto> {

    @Override
    public Rol requestToEntity(EditarRolRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Rol rol = new Rol();
        rol.setIdRol(dto.getIdRol());
        rol.setNombre(dto.getNombre());
        rol.setDescripcion(dto.getDescripcion());

        return rol;
    }

    @Override
    public EditarRolResponseDto entityToResponse(Rol entity) {
        if (entity == null) {
            return null;
        }

        EditarRolResponseDto dto = new EditarRolResponseDto();
        dto.setIdRol(entity.getIdRol());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());

        return dto;
    }
}
