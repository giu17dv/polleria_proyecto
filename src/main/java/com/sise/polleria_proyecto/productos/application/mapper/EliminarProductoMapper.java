package com.sise.polleria_proyecto.productos.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.productos.application.dto.request.EliminarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.response.EliminarProductoResponseDto;
import com.sise.polleria_proyecto.productos.domain.entities.Producto;

@Component
public class EliminarProductoMapper implements IEntityDtoMapper<Producto, EliminarProductoRequestDto, EliminarProductoResponseDto> {

    @Override
    public Producto requestToEntity(EliminarProductoRequestDto requestDto) {
        Producto producto = new Producto();
        producto.setId_producto(requestDto.getIdProducto());
        return producto;
    }

    @Override
    public EliminarProductoResponseDto entityToResponse(Producto entity) {
        EliminarProductoResponseDto responseDto = new EliminarProductoResponseDto();
        responseDto.setIdProducto(entity.getId_producto());
        return responseDto;
    }
}
