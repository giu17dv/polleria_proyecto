package com.sise.polleria_proyecto.pedido.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sise.polleria_proyecto.pedido.domain.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}
