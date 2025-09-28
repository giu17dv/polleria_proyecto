package com.sise.polleria_proyecto.inventario.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.inventario.application.dto.request.EditarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.request.EliminarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.request.InsertarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.EditarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.EliminarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.InsertarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.ListarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.application.mapper.EditarInventarioMapper;
import com.sise.polleria_proyecto.inventario.application.mapper.EliminarInventarioMapper;
import com.sise.polleria_proyecto.inventario.application.mapper.InsertarInventarioMapper;
import com.sise.polleria_proyecto.inventario.application.mapper.ListarInventarioMapper;
import com.sise.polleria_proyecto.inventario.domain.entity.Inventario;
import com.sise.polleria_proyecto.inventario.domain.service.InventarioDomainService;

@Service
public class InventarioApplicationService {

    @Autowired
    private InventarioDomainService inventarioDomainService;

    @Autowired
    private InsertarInventarioMapper insertarInventarioMapper;

    @Autowired
    private EditarInventarioMapper editarInventarioMapper;

    @Autowired
    private EliminarInventarioMapper eliminarInventarioMapper;

    @Autowired
    private ListarInventarioMapper listarInventarioMapper;

    // Insertar
    public InsertarInventarioResponseDto insertarInventario(InsertarInventarioRequestDto requestDto) {
        Inventario inventario = inventarioDomainService.insertarInventario(
                insertarInventarioMapper.requestToEntity(requestDto));
        return insertarInventarioMapper.entityToResponse(inventario);
    }

    // Listar
    public List<ListarInventarioResponseDto> listarInventarios() {
        return inventarioDomainService.listarInventarios()
                .stream()
                .map(listarInventarioMapper::entityToResponse)
                .toList();
    }

    // Editar
    public EditarInventarioResponseDto editarInventario(EditarInventarioRequestDto requestDto) {
        Inventario inventario = inventarioDomainService.editarInventario(
                editarInventarioMapper.requestToEntity(requestDto));
        return editarInventarioMapper.entityToResponse(inventario);
    }

    // Eliminar
    public EliminarInventarioResponseDto eliminarInventario(EliminarInventarioRequestDto requestDto) {
        Inventario inventario = eliminarInventarioMapper.requestToEntity(requestDto);
        inventario = inventarioDomainService.eliminarInventario(inventario);
        return eliminarInventarioMapper.entityToResponse(inventario);
    }
}
