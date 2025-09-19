package com.sise.polleria_proyecto.productos.domain.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.sise.polleria_proyecto.productos.domain.repository.ProductoRepository;
import com.sise.polleria_proyecto.productos.domain.entities.Producto;

@Service
public class ProductoDomainService {

    @Autowired
    ProductoRepository productoRepository;

    public Producto insertarProducto(Producto producto) { 
        Producto newProducto = productoRepository.save(producto);       
    return productoRepository.findById(newProducto.getId_producto()).orElse(null);        
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }
}
