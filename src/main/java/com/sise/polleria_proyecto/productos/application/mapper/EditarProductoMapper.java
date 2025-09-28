package com.sise.polleria_proyecto.productos.application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
import com.sise.polleria_proyecto.productos.application.dto.request.EditarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.response.EditarProductoResponseDto;
import com.sise.polleria_proyecto.productos.domain.entities.Producto;

@Component
public class EditarProductoMapper implements IEntityDtoMapper<Producto, EditarProductoRequestDto, EditarProductoResponseDto> {

    @Override
    public Producto requestToEntity(EditarProductoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setId_producto(dto.getIdProducto());
        producto.setNombre_producto(dto.getNombreProducto());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setTipo(dto.getTipo());
        // Agrega otros campos si tu entidad los tiene

        return producto;
    }

    @Override
    public EditarProductoResponseDto entityToResponse(Producto entity) {
        if (entity == null) {
            return null;
        }

        EditarProductoResponseDto dto = new EditarProductoResponseDto();
        dto.setIdProducto(entity.getId_producto());
        dto.setNombreProducto(entity.getNombre_producto());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecio(entity.getPrecio());
        dto.setTipo(entity.getTipo());
        

        // Agrega otros campos si tu DTO los tiene

        return dto;
    }
}
