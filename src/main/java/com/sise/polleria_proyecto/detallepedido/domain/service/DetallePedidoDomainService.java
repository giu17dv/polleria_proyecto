package com.sise.polleria_proyecto.detallepedido.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sise.polleria_proyecto.detallepedido.domain.entities.DetallePedido;
import com.sise.polleria_proyecto.detallepedido.domain.repository.DetallePedidoRepository;


@Service
public class DetallePedidoDomainService {
    

    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    public DetallePedido insertarDetallePedido(DetallePedido detallePedido) {
        DetallePedido newDetallePedido = detallePedidoRepository.save(detallePedido);
        return detallePedidoRepository.findById(newDetallePedido.getIdDetallePedido()).orElse(null);
    }

    public List<DetallePedido> listarDetallePedidos() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedido editarDetallePedido(DetallePedido detallePedido) {
        if (detallePedidoRepository.existsById(detallePedido.getIdDetallePedido())) {
            detallePedidoRepository.save(detallePedido);
            return detallePedidoRepository.findById(detallePedido.getIdDetallePedido()).orElse(null);
        } else {
            return null;
        }
    }

    public DetallePedido eliminarDetallePedido(DetallePedido detallePedido) {
        if (detallePedidoRepository.existsById(detallePedido.getIdDetallePedido())) {
            detallePedidoRepository.deleteById(detallePedido.getIdDetallePedido());
            return detallePedido;
        } else {
            return null;
        }
    }
}
