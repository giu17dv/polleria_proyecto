package com.sise.polleria_proyecto.rol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sise.polleria_proyecto.rol.domain.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    
}
