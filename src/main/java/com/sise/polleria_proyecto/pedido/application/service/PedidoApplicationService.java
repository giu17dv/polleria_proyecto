package com.sise.polleria_proyecto.pedido.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.pedido.application.dto.request.EditarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.request.EliminarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.request.InsertarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.EditarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.EliminarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.InsertarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.ListarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.application.mapper.EditarPedidoMapper;
import com.sise.polleria_proyecto.pedido.application.mapper.EliminarPedidoMapper;
import com.sise.polleria_proyecto.pedido.application.mapper.InsertarPedidoMapper;
import com.sise.polleria_proyecto.pedido.application.mapper.ListarPedidoMapper;
import com.sise.polleria_proyecto.pedido.domain.entities.Pedido;
import com.sise.polleria_proyecto.pedido.domain.service.PedidoDomainService;

@Service
public class PedidoApplicationService {
    

    @Autowired
    PedidoDomainService pedidoDomainService;

    @Autowired
    InsertarPedidoMapper insertarPedidoMapper;

    @Autowired
    EditarPedidoMapper editarPedidoMapper;

    @Autowired
    EliminarPedidoMapper eliminarPedidoMapper;

    @Autowired
    ListarPedidoMapper listarPedidoMapper;

    public InsertarPedidoResponseDto insertarPedido(InsertarPedidoRequestDto requestDto) {
        Pedido pedido = pedidoDomainService.insertarPedido(insertarPedidoMapper.requestToEntity(requestDto));
        return insertarPedidoMapper.entityToResponse(pedido);
    }

    public EditarPedidoResponseDto editarPedido(EditarPedidoRequestDto requestDto) {
        Pedido pedido = pedidoDomainService.editarPedido(editarPedidoMapper.requestToEntity(requestDto));
        return editarPedidoMapper.entityToResponse(pedido);
    }
    public EliminarPedidoResponseDto eliminarPedido(EliminarPedidoRequestDto requestDto) {
        Pedido pedido = eliminarPedidoMapper.requestToEntity(requestDto);
        pedido = pedidoDomainService.eliminarPedido(pedido);
        return eliminarPedidoMapper.entityToResponse(pedido);
    }

    public List<ListarPedidoResponseDto> listarPedido( ) {
        return pedidoDomainService.listarPedido().stream().map(listarPedidoMapper::entityToResponse). toList();
    }

    // Similar methods for editarPedido and eliminarPedido can be added here



}
