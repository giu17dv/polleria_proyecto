package com.sise.polleria_proyecto.Usuario.Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sise.polleria_proyecto.Usuario.Application.dto.request.InsertarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.InsertarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.mapper.InsertarUsuarioMapper;
import com.sise.polleria_proyecto.Usuario.Domain.Model.Usuario;
import com.sise.polleria_proyecto.Usuario.Domain.service.UsuarioDomainService;




@Service
public class UsuarioApplicationService {

    @Autowired
    UsuarioDomainService usuarioDomainService;

    @Autowired
    InsertarUsuarioMapper insertarUsuarioMapper;
    
    public InsertarUsuarioResponseDto insertarUsuario(InsertarUsuarioRequestDto requestDto) {
        Usuario usuario = usuarioDomainService.insertarUsuario(insertarUsuarioMapper.requestToEntity(requestDto));
        return insertarUsuarioMapper.entityToResponse(usuario);
    }
}
