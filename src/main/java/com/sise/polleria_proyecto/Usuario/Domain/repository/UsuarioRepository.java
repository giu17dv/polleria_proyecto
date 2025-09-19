package com.sise.polleria_proyecto.Usuario.Domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sise.polleria_proyecto.Usuario.Domain.Model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
