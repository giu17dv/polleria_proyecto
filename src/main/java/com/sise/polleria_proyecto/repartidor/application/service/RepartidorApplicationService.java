package com.sise.polleria_proyecto.repartidor.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.repartidor.application.dto.request.EditarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.request.EliminarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.request.InsertarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.EditarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.EliminarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.InsertarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.ListarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.application.mapper.EditarRepartidorMapper;
import com.sise.polleria_proyecto.repartidor.application.mapper.EliminarRepartidorMapper;
import com.sise.polleria_proyecto.repartidor.application.mapper.InsertarRepartidorMapper;
import com.sise.polleria_proyecto.repartidor.application.mapper.ListarRepartidorMapper;
import com.sise.polleria_proyecto.repartidor.domain.entity.Repartidor;
import com.sise.polleria_proyecto.repartidor.domain.service.RepartidorDomainService;

@Service
public class RepartidorApplicationService {

    @Autowired
    private RepartidorDomainService repartidorDomainService;

    @Autowired
    private InsertarRepartidorMapper insertarRepartidorMapper;

    @Autowired
    private EditarRepartidorMapper editarRepartidorMapper;

    @Autowired
    private EliminarRepartidorMapper eliminarRepartidorMapper;

    @Autowired
    private ListarRepartidorMapper listarRepartidorMapper;

    // Insertar
    public InsertarRepartidorResponseDto insertarRepartidor(InsertarRepartidorRequestDto requestDto) {
        Repartidor repartidor = repartidorDomainService.insertarRepartidor(
                insertarRepartidorMapper.requestToEntity(requestDto));
        return insertarRepartidorMapper.entityToResponse(repartidor);
    }

    // Listar
    public List<ListarRepartidorResponseDto> listarRepartidores() {
        return repartidorDomainService.listarRepartidores()
                .stream()
                .map(listarRepartidorMapper::entityToResponse)
                .toList();
    }

    // Editar
    public EditarRepartidorResponseDto editarRepartidor(EditarRepartidorRequestDto requestDto) {
        Repartidor repartidor = repartidorDomainService.editarRepartidor(
                editarRepartidorMapper.requestToEntity(requestDto));
        return editarRepartidorMapper.entityToResponse(repartidor);
    }

    // Eliminar
    public EliminarRepartidorResponseDto eliminarRepartidor(EliminarRepartidorRequestDto requestDto) {
        Repartidor repartidor = eliminarRepartidorMapper.requestToEntity(requestDto);
        repartidor = repartidorDomainService.eliminarRepartidor(repartidor);
        return eliminarRepartidorMapper.entityToResponse(repartidor);
    }
}
