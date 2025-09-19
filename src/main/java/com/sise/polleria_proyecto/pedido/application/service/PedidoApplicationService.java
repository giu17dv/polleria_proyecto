package com.sise.polleria_proyecto.pedido.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sise.polleria_proyecto.pedido.application.dto.request.InsertarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.InsertarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.application.mapper.InsertarPedidoMapper;
import com.sise.polleria_proyecto.pedido.domain.entities.Pedido;
import com.sise.polleria_proyecto.pedido.domain.service.PedidoDomainService;

@Service
public class PedidoApplicationService {
    

    @Autowired
    PedidoDomainService pedidoDomainService;

    @Autowired
    InsertarPedidoMapper insertarPedidoMapper;

    public InsertarPedidoResponseDto insertarPedido(InsertarPedidoRequestDto requestDto) {
        Pedido pedido = pedidoDomainService.insertarPedido(insertarPedidoMapper.requestToEntity(requestDto));
        return insertarPedidoMapper.entityToResponse(pedido);
    }

}
