package com.sise.polleria_proyecto.inventario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.inventario.application.dto.request.EditarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.EditarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.domain.entity.Inventario;

@Component
public class EditarInventarioMapper implements IEntityDtoMapper<Inventario, EditarInventarioRequestDto, EditarInventarioResponseDto> {

    @Override
    public Inventario requestToEntity(EditarInventarioRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Inventario inventario = new Inventario();
        inventario.setIdInventario(dto.getIdInventario());
        inventario.setIdProducto(dto.getIdProducto());
        inventario.setCantidad(dto.getCantidad());
        inventario.setStockMinimo(dto.getStockMinimo());
        inventario.setUbicacion(dto.getUbicacion());

        return inventario;
    }

    @Override
    public EditarInventarioResponseDto entityToResponse(Inventario entity) {
        if (entity == null) {
            return null;
        }

        EditarInventarioResponseDto dto = new EditarInventarioResponseDto();
        dto.setIdInventario(entity.getIdInventario());
        dto.setIdProducto(entity.getIdProducto());
        dto.setCantidad(entity.getCantidad());
        dto.setStockMinimo(entity.getStockMinimo());
        dto.setUbicacion(entity.getUbicacion());
        dto.setFechaModificacion(entity.getFechaModificacion());

        return dto;
    }
}
