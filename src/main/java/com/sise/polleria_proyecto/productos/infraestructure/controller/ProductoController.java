package com.sise.polleria_proyecto.productos.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.polleria_proyecto.productos.application.dto.request.InsertarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.response.InsertarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.service.ProductoApplicationService;


@RestController
@RequestMapping("/productos")

public class ProductoController {
    
    @Autowired
    private ProductoApplicationService productoApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarProductoResponseDto> insertarProducto(@RequestBody InsertarProductoRequestDto requestDto) {
        
        try {
            InsertarProductoResponseDto responseDto = productoApplicationService.insertarProducto(requestDto);
            
            
            
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            // Manejo de errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  
        }
    }
    
}
