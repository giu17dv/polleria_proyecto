package com.sise.polleria_proyecto.comprobantepago.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.polleria_proyecto.comprobantepago.domain.entity.ComprobantePago;

@Repository
public interface ComprobantePagoRepository extends JpaRepository<ComprobantePago, Integer> {
    
}
