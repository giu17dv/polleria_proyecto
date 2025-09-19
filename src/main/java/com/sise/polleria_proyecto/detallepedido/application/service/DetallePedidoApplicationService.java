package com.sise.polleria_proyecto.detallepedido.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.InsertarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.InsertarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.mapper.InsertarDetallePedidoMapper;
import com.sise.polleria_proyecto.detallepedido.domain.entities.DetallePedido;
import com.sise.polleria_proyecto.detallepedido.domain.service.DetallePedidoDomainService;



@Service
public class DetallePedidoApplicationService {
    

    @Autowired
    DetallePedidoDomainService detallePedidoDomainService;

    @Autowired
    InsertarDetallePedidoMapper insertarDetallePedidoMapper;

    public InsertarDetallePedidoResponseDto insertarDetallePedido(InsertarDetallePedidoRequestDto requestDto) {
        DetallePedido detallePedido = detallePedidoDomainService.insertarDetallePedido(insertarDetallePedidoMapper.requestToEntity(requestDto));
        return insertarDetallePedidoMapper.entityToResponse(detallePedido);
    }
}
