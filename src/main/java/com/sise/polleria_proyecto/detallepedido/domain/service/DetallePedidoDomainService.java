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
}
