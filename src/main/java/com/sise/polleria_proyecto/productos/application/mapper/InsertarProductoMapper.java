package com.sise.polleria_proyecto.productos.application.mapper;

import com.sise.polleria_proyecto.productos.application.dto.request.InsertarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.response.InsertarProductoResponseDto;
import com.sise.polleria_proyecto.common.application.IEntityDtoMapper;
import com.sise.polleria_proyecto.productos.domain.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class InsertarProductoMapper implements IEntityDtoMapper<Producto, InsertarProductoRequestDto, InsertarProductoResponseDto> {

    @Override
    public Producto requestToEntity(InsertarProductoRequestDto requestDto) {
        Producto producto = new Producto();
        producto.setNombre_producto(requestDto.getNombre_producto());
        producto.setDescripcion(requestDto.getDescripcion());
        producto.setPrecio(requestDto.getPrecio());
        producto.setTipo(requestDto.getTipo());
        return producto;
    }

    @Override
    public InsertarProductoResponseDto entityToResponse(Producto entity) {
        InsertarProductoResponseDto responseDto = new InsertarProductoResponseDto();
        
        responseDto.setNombre_producto(entity.getNombre_producto());
        responseDto.setDescripcion(entity.getDescripcion());
        responseDto.setPrecio(entity.getPrecio());
        responseDto.setTipo(entity.getTipo());
        responseDto.setFecha_creacion(entity.getFecha_creacion());
        
        return responseDto;
    }

    
    
    
}
