package com.sise.polleria_proyecto.Usuario.Infraestructure.Controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sise.polleria_proyecto.common.application.dto.response.BaseResponseDto;
 

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
 
import com.sise.polleria_proyecto.Usuario.Application.dto.request.EditarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.request.EliminarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.request.InsertarUsuarioRequestDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.EditarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.EliminarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.InsertarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.dto.response.ListarUsuarioResponseDto;
import com.sise.polleria_proyecto.Usuario.Application.service.UsuarioApplicationService;
 

@Tag(name = "Usuarios", description = "Gestión completa de usuarios del sistema (CRUD)")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
 
    @Autowired
    private UsuarioApplicationService usuarioApplicationService;
 
    // *** 1. INSERTAR (POST) ***
    @Operation(summary = "Registra un nuevo usuario en el sistema", description = "Crea un nuevo usuario y devuelve el objeto creado.")
    @ApiResponse(
        responseCode = "201",
        description = "Usuario creado exitosamente",
        content = @Content(
            schema = @Schema(implementation = InsertarUsuarioResponseDto.class)
        )
    )
    @ApiResponse(responseCode = "400", description = "Error de validación de campos", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PostMapping
    public ResponseEntity<BaseResponseDto> insertarUsuario(
        @RequestBody InsertarUsuarioRequestDto requestDto
    ) {
        try {
            InsertarUsuarioResponseDto responseData = usuarioApplicationService.insertarUsuario(requestDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(BaseResponseDto.success(responseData, "Usuario registrado exitosamente."));
        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al registrar el usuario."));
        }
    }
 
    // *** 2. EDITAR (PUT) ***
    @Operation(summary = "Actualiza la información de un usuario existente", description = "Busca el usuario por ID y actualiza sus campos.")
    @ApiResponse(
        responseCode = "200",
        description = "Usuario editado exitosamente",
        content = @Content(
            schema = @Schema(implementation = EditarUsuarioResponseDto.class)
        )
    )
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de campos", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PutMapping
    public ResponseEntity<BaseResponseDto> editarUsuario(@RequestBody EditarUsuarioRequestDto requestDto) {
        EditarUsuarioResponseDto responseData = usuarioApplicationService.editarUsuario(requestDto);
       
        if (responseData != null) {

            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Usuario actualizado."));
        } else {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(BaseResponseDto.error("El usuario a editar no fue encontrado."));
        }
    }
 
    // *** 3. ELIMINAR (DELETE) ***
    @Operation(summary = "Elimina un usuario por ID", description = "Elimina lógicamente un usuario del sistema y devuelve la confirmación.")
    @ApiResponse(
        responseCode = "200",
        description = "Usuario eliminado exitosamente",
        content = @Content(
            schema = @Schema(implementation = EliminarUsuarioResponseDto.class)
        )
    )
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @DeleteMapping
    public ResponseEntity<BaseResponseDto> eliminarUsuario(@RequestBody EliminarUsuarioRequestDto requestDto) {
        try {
            EliminarUsuarioResponseDto responseData = usuarioApplicationService.eliminarUsuario(requestDto);

            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Usuario eliminado correctamente."));
        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al intentar eliminar el usuario."));
        }
    }
 
    // *** 4. LISTAR (GET) ***
    @Operation(summary = "Obtiene la lista de todos los usuarios", description = "Devuelve una lista de todos los usuarios activos del sistema.")
    @ApiResponse(
        responseCode = "200",
        description = "Lista de usuarios obtenida exitosamente",
        content = @Content(
            array = @ArraySchema(schema = @Schema(implementation = ListarUsuarioResponseDto.class))
        )
    )
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @GetMapping
    public ResponseEntity<BaseResponseDto> listarUsuarios() {
        try {
            List<ListarUsuarioResponseDto> usuarios = usuarioApplicationService.listarUsuarios();

            return ResponseEntity.ok(BaseResponseDto.success(usuarios, "Lista de usuarios obtenida."));
        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error al intentar listar los usuarios."));
        }
    }
}