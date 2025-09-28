package com.sise.polleria_proyecto.common.application.config;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
 
import com.sise.polleria_proyecto.common.application.dto.response.BaseResponseDto;
 
@RestControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseDto> handleValidationException(
        MethodArgumentNotValidException ex
    ) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            //errors.add("El campo " + error.getField() + " incumple con que "+error.getDefaultMessage())
            errors.add("El campo '" + error.getField() + "' " + error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(BaseResponseDto.error("Error de validación", errors));
    }
   
}