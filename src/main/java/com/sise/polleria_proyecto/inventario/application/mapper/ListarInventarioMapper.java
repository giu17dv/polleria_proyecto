package com.sise.polleria_proyecto.inventario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.inventario.application.dto.request.ListarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.ListarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.domain.entity.Inventario;

@Component
public class ListarInventarioMapper implements IEntityDtoMapper<Inventario, ListarInventarioRequestDto, ListarInventarioResponseDto> {

    @Override
    public Inventario requestToEntity(ListarInventarioRequestDto dto) {
        // Si el request de listar no tiene filtros, devolvemos un inventario vacío
        return new Inventario();
    }

    @Override
    public ListarInventarioResponseDto entityToResponse(Inventario entity) {
        ListarInventarioResponseDto responseDto = new ListarInventarioResponseDto();
        responseDto.setIdInventario(entity.getIdInventario());
        responseDto.setIdProducto(entity.getIdProducto());
        responseDto.setCantidad(entity.getCantidad());
        responseDto.setStockMinimo(entity.getStockMinimo());
        responseDto.setUbicacion(entity.getUbicacion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        responseDto.setFechaModificacion(entity.getFechaModificacion());
        return responseDto;
    }
}
