package com.sise.polleria_proyecto.detallepedido.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.polleria_proyecto.detallepedido.domain.entities.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
    
}
