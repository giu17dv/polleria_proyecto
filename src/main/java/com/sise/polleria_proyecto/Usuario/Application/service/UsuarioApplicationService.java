package com.sise.polleria_proyecto.Usuario.Application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.polleria_proyecto.Usuario.Application.dto.request.EditarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.request.EliminarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.request.InsertarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.EditarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.EliminarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.InsertarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.ListarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.mapper.EditarUsuarioMapper;
import com.sise.polleria_proyecto.Usuario.Application.mapper.EliminarUsuarioMapper;
import com.sise.polleria_proyecto.Usuario.Application.mapper.InsertarUsuarioMapper;
import com.sise.polleria_proyecto.Usuario.Application.mapper.ListarUsuarioMapper;
import com.sise.polleria_proyecto.Usuario.Domain.Model.Usuario;
import com.sise.polleria_proyecto.Usuario.Domain.service.UsuarioDomainService;




@Service
public class UsuarioApplicationService {

    @Autowired
    UsuarioDomainService usuarioDomainService;

    @Autowired
    InsertarUsuarioMapper insertarUsuarioMapper;

    @Autowired
    EditarUsuarioMapper editarUsuarioMapper;

    @Autowired
    EliminarUsuarioMapper eliminarUsuarioMapper;

    @Autowired
    ListarUsuarioMapper listarUsuarioMapper;
    
    public InsertarUsuarioResponseDto insertarUsuario(InsertarUsuarioRequestDto requestDto) {
        Usuario usuario = usuarioDomainService.insertarUsuario(insertarUsuarioMapper.requestToEntity(requestDto));
        return insertarUsuarioMapper.entityToResponse(usuario);
    }

    // Listar
    public List<ListarUsuarioResponseDto> listarUsuarios() {
        return usuarioDomainService.listarUsuarios()
                .stream()
                .map(listarUsuarioMapper::entityToResponse)
                .toList();
    }

    // Editar
    public EditarUsuarioResponseDto editarUsuario(EditarUsuarioRequestDto requestDto) {
        Usuario usuario = usuarioDomainService.editarUsuario(editarUsuarioMapper.requestToEntity(requestDto));
        return editarUsuarioMapper.entityToResponse(usuario);
    }

    // Eliminar
    public EliminarUsuarioResponseDto eliminarUsuario(EliminarUsuarioRequestDto requestDto) {
        Usuario usuario = eliminarUsuarioMapper.requestToEntity(requestDto);
        usuario = usuarioDomainService.eliminarUsuario(usuario);
        return eliminarUsuarioMapper.entityToResponse(usuario);
    }

}
