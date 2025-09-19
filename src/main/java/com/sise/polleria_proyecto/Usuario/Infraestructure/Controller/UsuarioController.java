package com.sise.polleria_proyecto.Usuario.Infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sise.polleria_proyecto.Usuario.Application.dto.request.InsertarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.InsertarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.service.UsuarioApplicationService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioApplicationService usuarioApplicationService;

    @PostMapping("")
    public ResponseEntity<InsertarUsuarioResponseDto> insertarUsuario(
        @RequestBody InsertarUsuarioRequestDto requestDto
    ) {
        try {
            InsertarUsuarioResponseDto responseDto = usuarioApplicationService.insertarUsuario(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}