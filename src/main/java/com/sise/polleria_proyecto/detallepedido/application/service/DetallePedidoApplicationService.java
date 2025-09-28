package com.sise.polleria_proyecto.detallepedido.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.detallepedido.application.dto.request.EditarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.EliminarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.InsertarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.EditarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.EliminarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.InsertarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.ListarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.mapper.EditarDetallePedidoMapper;
import com.sise.polleria_proyecto.detallepedido.application.mapper.EliminarDetallePedidoMapper;
import com.sise.polleria_proyecto.detallepedido.application.mapper.InsertarDetallePedidoMapper;
import com.sise.polleria_proyecto.detallepedido.application.mapper.ListarDetallePedidoMapper;
import com.sise.polleria_proyecto.detallepedido.domain.entities.DetallePedido;
import com.sise.polleria_proyecto.detallepedido.domain.service.DetallePedidoDomainService;



@Service
public class DetallePedidoApplicationService {
    

    @Autowired
    DetallePedidoDomainService detallePedidoDomainService;

    @Autowired
    InsertarDetallePedidoMapper insertarDetallePedidoMapper;

    @Autowired
    EditarDetallePedidoMapper editarDetallePedidoMapper;

    @Autowired
    EliminarDetallePedidoMapper eliminarDetallePedidoMapper;

    @Autowired
    ListarDetallePedidoMapper listarDetallePedidoMapper;

    public InsertarDetallePedidoResponseDto insertarDetallePedido(InsertarDetallePedidoRequestDto requestDto) {
        DetallePedido detallePedido = detallePedidoDomainService.insertarDetallePedido(insertarDetallePedidoMapper.requestToEntity(requestDto));
        return insertarDetallePedidoMapper.entityToResponse(detallePedido);
    }



    public List<ListarDetallePedidoResponseDto> listarDetallePedidos() {
        return detallePedidoDomainService.listarDetallePedidos().stream().map(listarDetallePedidoMapper::entityToResponse). toList();
    }

    public EditarDetallePedidoResponseDto editarDetallePedido(EditarDetallePedidoRequestDto requestDto) {
        DetallePedido detallePedido = detallePedidoDomainService.editarDetallePedido(editarDetallePedidoMapper.requestToEntity(requestDto));
        return editarDetallePedidoMapper.entityToResponse(detallePedido);
    }

    public EliminarDetallePedidoResponseDto eliminarDetallePedido(EliminarDetallePedidoRequestDto requestDto) {
        
        DetallePedido detallePedido = eliminarDetallePedidoMapper.requestToEntity(requestDto);
        detallePedido = detallePedidoDomainService.eliminarDetallePedido(detallePedido);
        return eliminarDetallePedidoMapper.entityToResponse(detallePedido);
    }

}
