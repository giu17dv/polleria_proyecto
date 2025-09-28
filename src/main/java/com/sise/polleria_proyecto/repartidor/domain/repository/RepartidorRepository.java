package com.sise.polleria_proyecto.repartidor.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.polleria_proyecto.repartidor.domain.entity.Repartidor;
@Repository
public interface RepartidorRepository extends JpaRepository<Repartidor, Integer> {
    
}
