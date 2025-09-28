package com.sise.polleria_proyecto.inventario.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sise.polleria_proyecto.inventario.domain.entity.Inventario;
@Repository

public interface InventarioRepository extends JpaRepository<Inventario, Integer>{
    
}
