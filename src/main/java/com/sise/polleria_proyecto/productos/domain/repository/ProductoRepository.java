package com.sise.polleria_proyecto.productos.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sise.polleria_proyecto.productos.domain.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    
}
