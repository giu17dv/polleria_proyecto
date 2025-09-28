package com.sise.polleria_proyecto.comprobantepago.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.comprobantepago.domain.entity.ComprobantePago;
import com.sise.polleria_proyecto.comprobantepago.domain.repository.ComprobantePagoRepository;

@Service
public class ComprobantePagoDomainService {

    @Autowired
    private ComprobantePagoRepository comprobantePagoRepository;

    // Insertar ComprobantePago
    public ComprobantePago insertarComprobantePago(ComprobantePago comprobantePago) {
        ComprobantePago newComprobante = comprobantePagoRepository.save(comprobantePago);
        return comprobantePagoRepository.findById(newComprobante.getIdComprobantePago()).orElse(null);
    }

    // Listar ComprobantesPago
    public List<ComprobantePago> listarComprobantesPago() {
        return comprobantePagoRepository.findAll();
    }

    // Editar ComprobantePago
    public ComprobantePago editarComprobantePago(ComprobantePago comprobantePago) {
        if (comprobantePagoRepository.existsById(comprobantePago.getIdComprobantePago())) {
            comprobantePagoRepository.save(comprobantePago);
            return comprobantePagoRepository.findById(comprobantePago.getIdComprobantePago()).orElse(null);
        } else {
            return null;
        }
    }

    // Eliminar ComprobantePago
    public ComprobantePago eliminarComprobantePago(ComprobantePago comprobantePago) {
        if (comprobantePagoRepository.existsById(comprobantePago.getIdComprobantePago())) {
            comprobantePagoRepository.deleteById(comprobantePago.getIdComprobantePago());
            return comprobantePago;
        } else {
            return null;
        }
    }
}
