package com.sise.polleria_proyecto.rol.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.rol.application.dto.request.EditarRolRequestDto;
import com.sise.polleria_proyecto.rol.application.dto.request.EliminarRolRequestDto;
import com.sise.polleria_proyecto.rol.application.dto.request.InsertarRolRequestDto;
import com.sise.polleria_proyecto.rol.application.dto.response.EditarRolResponseDto;
import com.sise.polleria_proyecto.rol.application.dto.response.EliminarRolResponseDto;
import com.sise.polleria_proyecto.rol.application.dto.response.InsertarRolResponseDto;
import com.sise.polleria_proyecto.rol.application.dto.response.ListarRolResponseDto;
import com.sise.polleria_proyecto.rol.application.mapper.EditarRolMapper;
import com.sise.polleria_proyecto.rol.application.mapper.EliminarRolMapper;
import com.sise.polleria_proyecto.rol.application.mapper.InsertarRolMapper;
import com.sise.polleria_proyecto.rol.application.mapper.ListarRolMapper;
import com.sise.polleria_proyecto.rol.domain.entity.Rol;
import com.sise.polleria_proyecto.rol.domain.service.RolDomainService;



@Service
public class RolApplicationService {

    @Autowired
    RolDomainService rolDomainService;

    @Autowired
    InsertarRolMapper insertarRolMapper;

    @Autowired
    EditarRolMapper editarRolMapper;

    @Autowired
    EliminarRolMapper eliminarRolMapper;

    @Autowired
    ListarRolMapper listarRolMapper;

    // Insertar
    public InsertarRolResponseDto insertarRol(InsertarRolRequestDto requestDto) {
        Rol rol = rolDomainService.insertarRol(insertarRolMapper.requestToEntity(requestDto));
        return insertarRolMapper.entityToResponse(rol);
    }

    // Listar
    public List<ListarRolResponseDto> listarRoles() {
        return rolDomainService.listarRoles()
                .stream()
                .map(listarRolMapper::entityToResponse)
                .toList();
    }

    // Editar
    public EditarRolResponseDto editarRol(EditarRolRequestDto requestDto) {
        Rol rol = rolDomainService.editarRol(editarRolMapper.requestToEntity(requestDto));
        return editarRolMapper.entityToResponse(rol);
    }

    // Eliminar
    public EliminarRolResponseDto eliminarRol(EliminarRolRequestDto requestDto) {
        Rol rol = eliminarRolMapper.requestToEntity(requestDto);
        rol = rolDomainService.eliminarRol(rol);
        return eliminarRolMapper.entityToResponse(rol);
    }
}
