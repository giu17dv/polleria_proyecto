package com.sise.polleria_proyecto.Usuario.Application.dto.request;

import lombok.Data;

@Data
public class InsertarUsuarioRequestDto {
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String telefono;
    private String direccion;
    private String rol;
}