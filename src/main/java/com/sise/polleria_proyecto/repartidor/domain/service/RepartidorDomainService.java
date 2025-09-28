package com.sise.polleria_proyecto.repartidor.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.repartidor.domain.entity.Repartidor;
import com.sise.polleria_proyecto.repartidor.domain.repository.RepartidorRepository;

@Service
public class RepartidorDomainService {

    @Autowired
    private RepartidorRepository repartidorRepository;

    // Insertar Repartidor
    public Repartidor insertarRepartidor(Repartidor repartidor) {
        Repartidor newRepartidor = repartidorRepository.save(repartidor);
        return repartidorRepository.findById(newRepartidor.getIdRepartidor()).orElse(null);
    }

    // Listar Repartidores
    public List<Repartidor> listarRepartidores() {
        return repartidorRepository.findAll();
    }

    // Editar Repartidor
    public Repartidor editarRepartidor(Repartidor repartidor) {
        if (repartidorRepository.existsById(repartidor.getIdRepartidor())) {
            repartidorRepository.save(repartidor);
            return repartidorRepository.findById(repartidor.getIdRepartidor()).orElse(null);
        } else {
            return null;
        }
    }

    // Eliminar Repartidor
    public Repartidor eliminarRepartidor(Repartidor repartidor) {
        if (repartidorRepository.existsById(repartidor.getIdRepartidor())) {
            repartidorRepository.deleteById(repartidor.getIdRepartidor());
            return repartidor;
        } else {
            return null;
        }
    }
}
