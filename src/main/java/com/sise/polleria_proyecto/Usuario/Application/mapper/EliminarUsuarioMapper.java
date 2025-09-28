package com.sise.polleria_proyecto.Usuario.Application.mapper;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.Usuario.Application.dto.request.EliminarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.EliminarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Domain.Model.Usuario;
import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;

@Component
public class EliminarUsuarioMapper implements IEntityDtoMapper<Usuario, EliminarUsuarioRequestDto, EliminarUsuarioResponseDto> {
   
    @Override
    public Usuario requestToEntity(EliminarUsuarioRequestDto dto) {
 
        Usuario entity = new Usuario();
        entity.setIdUsuario(dto.getIdUsuario());
        return entity;
    }
 
    @Override
    public EliminarUsuarioResponseDto entityToResponse(Usuario entity) {
        EliminarUsuarioResponseDto responseDto = new EliminarUsuarioResponseDto();
       
        responseDto.setIdUsuario(entity.getIdUsuario());
       
        String nombreCompleto = entity.getNombre() + " " + entity.getApellido();
        responseDto.setNombreUsuario(nombreCompleto);
       
 
        
       
        responseDto.setMensajeConfirmacion("El usuario ha sido procesado para eliminación lógica.");
       
        return responseDto;
    }
}
