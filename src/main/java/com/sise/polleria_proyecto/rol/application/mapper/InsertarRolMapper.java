package com.sise.polleria_proyecto.rol.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.rol.application.dto.request.InsertarRolRequestDto;
import com.sise.polleria_proyecto.rol.application.dto.response.InsertarRolResponseDto;
import com.sise.polleria_proyecto.rol.domain.entity.Rol;



@Component
public class InsertarRolMapper implements IEntityDtoMapper<Rol, InsertarRolRequestDto, InsertarRolResponseDto> {

    @Override
    public Rol requestToEntity(InsertarRolRequestDto requestDto) {
        Rol rol = new Rol();
        rol.setNombre(requestDto.getNombre());
        rol.setDescripcion(requestDto.getDescripcion());
        return rol;
    }

    @Override
    public InsertarRolResponseDto entityToResponse(Rol entity) {
        InsertarRolResponseDto responseDto = new InsertarRolResponseDto();
        responseDto.setIdRol(entity.getIdRol());
        responseDto.setNombre(entity.getNombre());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
