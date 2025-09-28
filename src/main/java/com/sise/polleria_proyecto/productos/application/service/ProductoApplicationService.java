package com.sise.polleria_proyecto.productos.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.productos.application.dto.request.EditarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.request.EliminarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.request.InsertarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.response.EditarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.dto.response.EliminarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.dto.response.InsertarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.dto.response.ListarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.mapper.EditarProductoMapper;
import com.sise.polleria_proyecto.productos.application.mapper.EliminarProductoMapper;
import com.sise.polleria_proyecto.productos.application.mapper.InsertarProductoMapper;
import com.sise.polleria_proyecto.productos.application.mapper.ListarProductoMapper;
import com.sise.polleria_proyecto.productos.domain.entities.Producto;
import com.sise.polleria_proyecto.productos.domain.service.ProductoDomainService;

@Service
public class ProductoApplicationService {
    
    @Autowired
    ProductoDomainService productoDomainService;

    @Autowired
    InsertarProductoMapper insertarProductoMapper;

    @Autowired
    EliminarProductoMapper eliminarProductoMapper;

    @Autowired
    EditarProductoMapper editarProductoMapper;

    @Autowired
    ListarProductoMapper listarProductoMapper;

    public InsertarProductoResponseDto insertarProducto(InsertarProductoRequestDto requestDto) {
        Producto producto = productoDomainService.insertarProducto(insertarProductoMapper.requestToEntity(requestDto));

        
        return insertarProductoMapper.entityToResponse(producto);


    }

     public List<ListarProductoResponseDto> listarProductos() {
        return productoDomainService.listarProductos()
                .stream()
                .map(listarProductoMapper::entityToResponse)
                .toList();
    }

    public EditarProductoResponseDto editarProducto(EditarProductoRequestDto requestDto) {
        Producto producto = productoDomainService.editarProducto(editarProductoMapper.requestToEntity(requestDto));
        return editarProductoMapper.entityToResponse(producto);
    }

    public EliminarProductoResponseDto eliminarProducto(EliminarProductoRequestDto requestDto) {
        Producto producto = eliminarProductoMapper.requestToEntity(requestDto);
        producto = productoDomainService.eliminarProducto(producto);
        return eliminarProductoMapper.entityToResponse(producto);
    }

}