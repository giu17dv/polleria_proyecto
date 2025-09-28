package com.sise.polleria_proyecto.Usuario.Application.dto.request;
 
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
 
@Data
@Schema(description = "DTO de solicitud vacío para listar todos los usuarios. Si se implementa filtrado o paginación, los campos irían aquí.")
public class ListarUsuarioRequestDto {
   
 
}