package com.sise.polleria_proyecto.Usuario.Application.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class InsertarUsuarioResponseDto {
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDateTime fechaCreacion;
}
