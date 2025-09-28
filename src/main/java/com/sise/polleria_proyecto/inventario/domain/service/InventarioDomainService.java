package com.sise.polleria_proyecto.inventario.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.inventario.domain.entity.Inventario;
import com.sise.polleria_proyecto.inventario.domain.repository.InventarioRepository;

@Service
public class InventarioDomainService {

    @Autowired
    private InventarioRepository inventarioRepository;

    // Insertar Inventario
    public Inventario insertarInventario(Inventario inventario) {
        Inventario newInventario = inventarioRepository.save(inventario);
        return inventarioRepository.findById(newInventario.getIdInventario()).orElse(null);
    }

    // Listar Inventarios
    public List<Inventario> listarInventarios() {
        return inventarioRepository.findAll();
    }

    // Editar Inventario
    public Inventario editarInventario(Inventario inventario) {
        if (inventarioRepository.existsById(inventario.getIdInventario())) {
            inventarioRepository.save(inventario);
            return inventarioRepository.findById(inventario.getIdInventario()).orElse(null);
        } else {
            return null;
        }
    }

    // Eliminar Inventario
    public Inventario eliminarInventario(Inventario inventario) {
        if (inventarioRepository.existsById(inventario.getIdInventario())) {
            inventarioRepository.deleteById(inventario.getIdInventario());
            return inventario;
        } else {
            return null;
        }
    }
}
