package com.sise.polleria_proyecto.productos.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.productos.application.dto.request.ListarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.response.ListarProductoResponseDto;
import com.sise.polleria_proyecto.productos.domain.entities.Producto;

@Component
public class ListarProductoMapper implements IEntityDtoMapper<Producto, ListarProductoRequestDto, ListarProductoResponseDto> {
    
    @Override
    public Producto requestToEntity(ListarProductoRequestDto dto) {
        // Si ListarProductoRequestDto está vacío, devolvemos una nueva instancia de Producto
        return new Producto();
    }

    @Override
    public ListarProductoResponseDto entityToResponse(Producto entity) {
        ListarProductoResponseDto responseDto = new ListarProductoResponseDto();
        responseDto.setIdProducto(entity.getId_producto());
        responseDto.setNombreProducto(entity.getNombre_producto());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setPrecio(entity.getPrecio());
        responseDto.setTipo(entity.getTipo());
        // Agrega otros campos si tu entidad/DTO los tiene

        return responseDto;
    }
}
