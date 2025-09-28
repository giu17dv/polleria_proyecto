package com.sise.polleria_proyecto.rol.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.rol.application.dto.request.ListarRolRequestDto;
import com.sise.polleria_proyecto.rol.application.dto.response.ListarRolResponseDto;
import com.sise.polleria_proyecto.rol.domain.entity.Rol;



@Component
public class ListarRolMapper implements IEntityDtoMapper<Rol, ListarRolRequestDto, ListarRolResponseDto> {

    @Override
    public Rol requestToEntity(ListarRolRequestDto dto) {
        // Si el request de listar no tiene filtros, devolvemos un nuevo rol vacío
        return new Rol();
    }

    @Override
    public ListarRolResponseDto entityToResponse(Rol entity) {
        ListarRolResponseDto responseDto = new ListarRolResponseDto();
        responseDto.setIdRol(entity.getIdRol());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
