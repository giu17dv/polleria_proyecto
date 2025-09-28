package com.sise.polleria_proyecto.common.application.dto.response;
 
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import io.swagger.v3.oas.annotations.media.Schema;
 

 
@Getter
@Schema(description = "Contenedor de respuesta estándar para todas las operaciones de la API")
public class BaseResponseDto {
 
    @Schema(description = "Indica si la operación fue exitosa (true) o si hubo un error (false)", example = "true")
    private final boolean success;
 
    @Schema(description = "Mensaje descriptivo del resultado de la operación", example = "Consulta realizada con éxito")
    private final String message;
 
    @Schema(description = "Los datos de la respuesta (ej. un objeto, una lista, o null en caso de error)")
    private final Object data;
 
    @Schema(description = "Lista de errores específicos en caso de que 'success' sea false", nullable = true, example = "[\"El campo nombre es obligatorio\"]")
    private final List<String> errors;
 
 
    private BaseResponseDto(boolean success, String message, Object data, List<String> errors) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.errors = (errors != null) ? errors : Collections.emptyList();
    }
 
 
    public static BaseResponseDto success(Object data) {
        return success(data, "Ok");
    }
 
    public static BaseResponseDto success(Object data, String message) {
        return new BaseResponseDto(true, message, data, null);
    }
 
    public static BaseResponseDto error(String message) {
 
        return error(message, null);
    }
 
    public static BaseResponseDto error(String message, List<String> errors) {
        return new BaseResponseDto(false, message, null, errors);
    }
}