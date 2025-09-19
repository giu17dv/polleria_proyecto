package com.sise.polleria_proyecto.Usuario.Application.mapper;

import org.springframework.stereotype.Component;
import com.sise.polleria_proyecto.Usuario.Domain.Model.Usuario;
import com.sise.polleria_proyecto.Usuario.Application.dto.request.InsertarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.InsertarUsuarioResponseDto;
import com.sise.polleria_proyecto.common.application.IEntityDtoMapper;




@Component
public class InsertarUsuarioMapper implements IEntityDtoMapper<Usuario, InsertarUsuarioRequestDto, InsertarUsuarioResponseDto> {

    @Override
    public Usuario requestToEntity(InsertarUsuarioRequestDto requestDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(requestDto.getNombre());
        usuario.setApellido(requestDto.getApellido());
        usuario.setEmail(requestDto.getEmail());
        usuario.setContrasena(requestDto.getContrasena());
        usuario.setTelefono(requestDto.getTelefono());
        usuario.setDireccion(requestDto.getDireccion());
        usuario.setRol(requestDto.getRol());
        return usuario;
    }

    @Override
    public InsertarUsuarioResponseDto entityToResponse(Usuario entity) {
        InsertarUsuarioResponseDto responseDto = new InsertarUsuarioResponseDto();
        responseDto.setIdUsuario(entity.getIdUsuario());
        responseDto.setNombre(entity.getNombre());
        responseDto.setApellido(entity.getApellido());
        responseDto.setEmail(entity.getEmail());
        responseDto.setFechaCreacion(entity.getFechaCreacion());
        return responseDto;
    }
}
