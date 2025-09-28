package com.sise.polleria_proyecto.pedido.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.sise.polleria_proyecto.pedido.domain.entities.Pedido;
import com.sise.polleria_proyecto.pedido.domain.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoDomainService {
    
    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido insertarPedido(Pedido pedido) {
        Pedido newPedido = pedidoRepository.save(pedido);
        return pedidoRepository.findById(newPedido.getIdPedido()).orElse(null);
        
    }

    public List<Pedido> listarPedido() {
        return pedidoRepository.findAll();
    }

    public Pedido editarPedido(Pedido pedido) {
        if (pedidoRepository.existsById(pedido.getIdPedido())) {
            pedidoRepository.save(pedido);
            return pedidoRepository.findById(pedido.getIdPedido()).orElse(null);
        } else {
            return null;
        }
    }

    public Pedido eliminarPedido(Pedido pedido) {
        if (pedidoRepository.existsById(pedido.getIdPedido())) {
            pedidoRepository.deleteById(pedido.getIdPedido());
            return pedido;
        } else {
            return null;
        }
    }

}
