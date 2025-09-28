package com.sise.polleria_proyecto.rol.infraestructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.polleria_proyecto.common.application.dto.response.BaseResponseDto;
import com.sise.polleria_proyecto.rol.application.dto.request.*;
import com.sise.polleria_proyecto.rol.application.dto.response.*;
import com.sise.polleria_proyecto.rol.application.service.RolApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Roles", description = "Gestión completa de roles del sistema (CRUD)")
@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolApplicationService rolApplicationService;

    // *** 1. INSERTAR (POST) ***
    @Operation(summary = "Registra un nuevo rol en el sistema", description = "Crea un nuevo rol y devuelve el objeto creado.")
    @ApiResponse(responseCode = "201", description = "Rol creado exitosamente",
            content = @Content(schema = @Schema(implementation = InsertarRolResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de campos", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PostMapping
    public ResponseEntity<BaseResponseDto> insertarRol(@RequestBody InsertarRolRequestDto requestDto) {
        try {
            InsertarRolResponseDto responseData = rolApplicationService.insertarRol(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(BaseResponseDto.success(responseData, "Rol registrado exitosamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al registrar el rol."));
        }
    }

    // *** 2. EDITAR (PUT) ***
    @Operation(summary = "Actualiza la información de un rol existente", description = "Busca el rol por ID y actualiza sus campos.")
    @ApiResponse(responseCode = "200", description = "Rol editado exitosamente",
            content = @Content(schema = @Schema(implementation = EditarRolResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Rol no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de campos", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PutMapping
    public ResponseEntity<BaseResponseDto> editarRol(@RequestBody EditarRolRequestDto requestDto) {
        EditarRolResponseDto responseData = rolApplicationService.editarRol(requestDto);
        if (responseData != null) {
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Rol actualizado."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(BaseResponseDto.error("El rol a editar no fue encontrado."));
        }
    }

    // *** 3. ELIMINAR (DELETE) ***
    @Operation(summary = "Elimina un rol por ID", description = "Elimina lógicamente un rol del sistema y devuelve la confirmación.")
    @ApiResponse(responseCode = "200", description = "Rol eliminado exitosamente",
            content = @Content(schema = @Schema(implementation = EliminarRolResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Rol no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @DeleteMapping
    public ResponseEntity<BaseResponseDto> eliminarRol(@RequestBody EliminarRolRequestDto requestDto) {
        try {
            EliminarRolResponseDto responseData = rolApplicationService.eliminarRol(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Rol eliminado correctamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al intentar eliminar el rol."));
        }
    }

    // *** 4. LISTAR (GET) ***
    @Operation(summary = "Obtiene la lista de todos los roles", description = "Devuelve una lista de todos los roles activos del sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de roles obtenida exitosamente",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ListarRolResponseDto.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @GetMapping
    public ResponseEntity<BaseResponseDto> listarRoles() {
        try {
            List<ListarRolResponseDto> roles = rolApplicationService.listarRoles();
            return ResponseEntity.ok(BaseResponseDto.success(roles, "Lista de roles obtenida."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error al intentar listar los roles."));
        }
    }
}
