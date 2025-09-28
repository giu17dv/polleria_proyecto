package com.sise.polleria_proyecto.Usuario.Application.mapper;
 

 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.Usuario.Application.dto.request.EditarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.EditarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Domain.Model.Usuario;
import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
 
@Component
public class EditarUsuarioMapper implements IEntityDtoMapper<Usuario, EditarUsuarioRequestDto, EditarUsuarioResponseDto> {
 
    // Define un formato ISO estándar
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
 
    @Override
    public Usuario requestToEntity(EditarUsuarioRequestDto dto) {
        Usuario entity = new Usuario();
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setEmail(dto.getEmail());
        entity.setContrasena(dto.getContrasena());
        entity.setTelefono(dto.getTelefono());
        entity.setDireccion(dto.getDireccion());
        entity.setRol(dto.getRol());
        return entity;
    }
 
    @Override
    public EditarUsuarioResponseDto entityToResponse(Usuario entity) {
        EditarUsuarioResponseDto responseDto = new EditarUsuarioResponseDto();
       
 
        responseDto.setIdUsuario(entity.getIdUsuario());
       
        String nombreCompleto = entity.getNombre() + " " + entity.getApellido();
        responseDto.setNombreCompleto(nombreCompleto);
       
        responseDto.setEmail(entity.getEmail());
        responseDto.setRol(entity.getRol());
       
 
        LocalDateTime fechaModificacion = entity.getFechaModificacion();
        if (fechaModificacion != null) {
            responseDto.setFechaModificacion(fechaModificacion.format(FORMATTER));
        } else {
            responseDto.setFechaModificacion(null);
        }
       
        return responseDto;
    }
}
 