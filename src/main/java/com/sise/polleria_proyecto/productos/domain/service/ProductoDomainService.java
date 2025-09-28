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

    public Producto editarProducto(Producto producto) {
        if (productoRepository.existsById(producto.getId_producto())) {
            productoRepository.save(producto);
            return productoRepository.findById(producto.getId_producto()).orElse(null);
        } else {
            return null;
        }
    }

    public Producto eliminarProducto(Producto producto) {
        if (productoRepository.existsById(producto.getId_producto())) {
            productoRepository.deleteById(producto.getId_producto());
            return producto;
        } else {
            return null;
        }
    }
}
