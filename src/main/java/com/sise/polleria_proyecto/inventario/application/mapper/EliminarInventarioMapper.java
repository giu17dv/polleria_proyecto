package com.sise.polleria_proyecto.inventario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.inventario.application.dto.request.EliminarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.EliminarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.domain.entity.Inventario;

@Component
public class EliminarInventarioMapper implements IEntityDtoMapper<Inventario, EliminarInventarioRequestDto, EliminarInventarioResponseDto> {

    @Override
    public Inventario requestToEntity(EliminarInventarioRequestDto requestDto) {
        Inventario inventario = new Inventario();
        inventario.setIdInventario(requestDto.getIdInventario());
        return inventario;
    }

    @Override
    public EliminarInventarioResponseDto entityToResponse(Inventario entity) {
        EliminarInventarioResponseDto responseDto = new EliminarInventarioResponseDto();
        responseDto.setIdInventario(entity.getIdInventario());
        return responseDto;
    }
}
