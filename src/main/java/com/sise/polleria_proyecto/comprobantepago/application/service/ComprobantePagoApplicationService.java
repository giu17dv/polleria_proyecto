package com.sise.polleria_proyecto.comprobantepago.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.comprobantepago.application.dto.request.EditarComprobantePagoRequestDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.request.EliminarComprobantePagoRequestDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.request.InsertarComprobantePagoRequestDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.EditarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.EliminarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.InsertarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.ListarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.application.mapper.EditarComprobantePagoMapper;
import com.sise.polleria_proyecto.comprobantepago.application.mapper.EliminarComprobantePagoMapper;
import com.sise.polleria_proyecto.comprobantepago.application.mapper.InsertarComprobantePagoMapper;
import com.sise.polleria_proyecto.comprobantepago.application.mapper.ListarComprobantePagoMapper;
import com.sise.polleria_proyecto.comprobantepago.domain.entity.ComprobantePago;
import com.sise.polleria_proyecto.comprobantepago.domain.service.ComprobantePagoDomainService;


@Service
public class ComprobantePagoApplicationService {

    @Autowired
    private ComprobantePagoDomainService comprobantePagoDomainService;

    @Autowired
    private InsertarComprobantePagoMapper insertarComprobantePagoMapper;

    @Autowired
    private EditarComprobantePagoMapper editarComprobantePagoMapper;

    @Autowired
    private EliminarComprobantePagoMapper eliminarComprobantePagoMapper;

    @Autowired
    private ListarComprobantePagoMapper listarComprobantePagoMapper;

    // Insertar
    public InsertarComprobantePagoResponseDto insertarComprobantePago(InsertarComprobantePagoRequestDto requestDto) {
        ComprobantePago comprobante = comprobantePagoDomainService.insertarComprobantePago(
                insertarComprobantePagoMapper.requestToEntity(requestDto));
        return insertarComprobantePagoMapper.entityToResponse(comprobante);
    }

    // Listar
    public List<ListarComprobantePagoResponseDto> listarComprobantesPago() {
        return comprobantePagoDomainService.listarComprobantesPago()
                .stream()
                .map(listarComprobantePagoMapper::entityToResponse)
                .toList();
    }

    // Editar
    public EditarComprobantePagoResponseDto editarComprobantePago(EditarComprobantePagoRequestDto requestDto) {
        ComprobantePago comprobante = comprobantePagoDomainService.editarComprobantePago(
                editarComprobantePagoMapper.requestToEntity(requestDto));
        return editarComprobantePagoMapper.entityToResponse(comprobante);
    }

    // Eliminar
    public EliminarComprobantePagoResponseDto eliminarComprobantePago(EliminarComprobantePagoRequestDto requestDto) {
        ComprobantePago comprobante = eliminarComprobantePagoMapper.requestToEntity(requestDto);
        comprobante = comprobantePagoDomainService.eliminarComprobantePago(comprobante);
        return eliminarComprobantePagoMapper.entityToResponse(comprobante);
    }
}
