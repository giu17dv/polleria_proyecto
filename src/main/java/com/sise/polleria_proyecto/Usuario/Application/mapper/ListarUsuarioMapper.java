package com.sise.polleria_proyecto.Usuario.Application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.Usuario.Application.dto.request.ListarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.ListarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Domain.Model.Usuario;
import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;

@Component
public class ListarUsuarioMapper implements IEntityDtoMapper<Usuario, ListarUsuarioRequestDto, ListarUsuarioResponseDto> {
   
    @Override
    public Usuario requestToEntity(ListarUsuarioRequestDto dto) {
        return new Usuario();
    }
 
    @Override
    public ListarUsuarioResponseDto entityToResponse(Usuario entity) {
        ListarUsuarioResponseDto responseDto = new ListarUsuarioResponseDto();
       
        responseDto.setIdUsuario(entity.getIdUsuario());
       
        String nombreCompleto = entity.getNombre() + " " + entity.getApellido();
        responseDto.setNombreCompleto(nombreCompleto);
       
        responseDto.setEmail(entity.getEmail());
        responseDto.setTelefono(entity.getTelefono());
        responseDto.setDireccion(entity.getDireccion());
        responseDto.setRol(entity.getRol());
        responseDto.setEstado(entity.getEstado());
        
       
        return responseDto;
    }
}