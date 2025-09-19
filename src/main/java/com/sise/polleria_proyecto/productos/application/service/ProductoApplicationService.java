package com.sise.polleria_proyecto.productos.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.productos.application.dto.request.InsertarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.response.InsertarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.mapper.InsertarProductoMapper;
import com.sise.polleria_proyecto.productos.domain.entities.Producto;
import com.sise.polleria_proyecto.productos.domain.service.ProductoDomainService;

@Service
public class ProductoApplicationService {
    
    @Autowired
    ProductoDomainService productoDomainService;

    @Autowired
    InsertarProductoMapper insertarProductoMapper;

    public InsertarProductoResponseDto insertarProducto(InsertarProductoRequestDto requestDto) {
        Producto producto = productoDomainService.insertarProducto(insertarProductoMapper.requestToEntity(requestDto));

        
        return insertarProductoMapper.entityToResponse(producto);
    }
}