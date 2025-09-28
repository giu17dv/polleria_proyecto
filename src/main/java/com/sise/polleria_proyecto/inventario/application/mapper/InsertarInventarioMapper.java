package com.sise.polleria_proyecto.inventario.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.inventario.application.dto.request.InsertarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.InsertarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.domain.entity.Inventario;



@Component
public class InsertarInventarioMapper implements IEntityDtoMapper<Inventario, InsertarInventarioRequestDto, InsertarInventarioResponseDto> {

    @Override
    public Inventario requestToEntity(InsertarInventarioRequestDto requestDto) {
        Inventario inventario = new Inventario();
        inventario.setIdProducto(requestDto.getIdProducto());
        inventario.setCantidad(requestDto.getCantidad());
        inventario.setStockMinimo(requestDto.getStockMinimo());
        inventario.setUbicacion(requestDto.getUbicacion());

        return inventario;
    }

    @Override
    public InsertarInventarioResponseDto entityToResponse(Inventario entity) {
        InsertarInventarioResponseDto responseDto = new InsertarInventarioResponseDto();
        responseDto.setIdInventario(entity.getIdInventario());
        responseDto.setIdProducto(entity.getIdProducto());
        responseDto.setCantidad(entity.getCantidad());
        responseDto.setStockMinimo(entity.getStockMinimo());
        responseDto.setUbicacion(entity.getUbicacion());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
