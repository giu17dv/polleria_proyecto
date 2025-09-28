package com.sise.polleria_proyecto.rol.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.rol.application.dto.request.EliminarRolRequestDto;
import com.sise.polleria_proyecto.rol.application.dto.response.EliminarRolResponseDto;
import com.sise.polleria_proyecto.rol.domain.entity.Rol;



@Component
public class EliminarRolMapper implements IEntityDtoMapper<Rol, EliminarRolRequestDto, EliminarRolResponseDto> {

    @Override
    public Rol requestToEntity(EliminarRolRequestDto requestDto) {
        Rol rol = new Rol();
        rol.setIdRol(requestDto.getIdRol());
        return rol;
    }

    @Override
    public EliminarRolResponseDto entityToResponse(Rol entity) {
        EliminarRolResponseDto responseDto = new EliminarRolResponseDto();
        responseDto.setIdRol(entity.getIdRol());
        return responseDto;
    }
}
