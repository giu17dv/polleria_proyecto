package com.sise.polleria_proyecto.Usuario.Application.mapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.sise.polleria_proyecto.Usuario.Application.dto.request.InsertarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.InsertarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Domain.Model.Usuario;
import com.sise.polleria_proyecto.common.application.dto.response.IEntityDtoMapper;
 

 
@Component
public class InsertarUsuarioMapper implements IEntityDtoMapper<Usuario, InsertarUsuarioRequestDto, InsertarUsuarioResponseDto> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
 
    @Override
    public Usuario requestToEntity(InsertarUsuarioRequestDto dto) {
        Usuario entity = new Usuario();
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
    public InsertarUsuarioResponseDto entityToResponse(Usuario entity) {
        InsertarUsuarioResponseDto responseDto = new InsertarUsuarioResponseDto();
        responseDto.setIdUsuario(entity.getIdUsuario());
       
        String nombreCompleto = entity.getNombre() + " " + entity.getApellido();
        responseDto.setNombreCompleto(nombreCompleto);
       
        responseDto.setEmail(entity.getEmail());
        responseDto.setRol(entity.getRol());
        LocalDateTime fechaCreacion = entity.getFechaCreacion();
        if (fechaCreacion != null) {
            responseDto.setFechaCreacion(fechaCreacion.format(FORMATTER));
        } else {
            responseDto.setFechaCreacion(null);
        }
       
        return responseDto;
    }
}
