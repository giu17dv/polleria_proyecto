package com.sise.polleria_proyecto.rol.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.rol.domain.entity.Rol;
import com.sise.polleria_proyecto.rol.domain.repository.RolRepository;



@Service
public class RolDomainService {

    @Autowired
    RolRepository rolRepository;

    // Insertar Rol
    public Rol insertarRol(Rol rol) {
        Rol newRol = rolRepository.save(rol);
        return rolRepository.findById(newRol.getIdRol()).orElse(null);
    }

    // Listar Roles
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    // Editar Rol
    public Rol editarRol(Rol rol) {
        if (rolRepository.existsById(rol.getIdRol())) {
            rolRepository.save(rol);
            return rolRepository.findById(rol.getIdRol()).orElse(null);
        } else {
            return null;
        }
    }

    // Eliminar Rol
    public Rol eliminarRol(Rol rol) {
        if (rolRepository.existsById(rol.getIdRol())) {
            rolRepository.deleteById(rol.getIdRol());
            return rol;
        } else {
            return null;
        }
    }
}
