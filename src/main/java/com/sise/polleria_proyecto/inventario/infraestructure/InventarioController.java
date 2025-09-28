package com.sise.polleria_proyecto.inventario.infraestructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.polleria_proyecto.common.application.dto.response.BaseResponseDto;
import com.sise.polleria_proyecto.inventario.application.dto.request.EditarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.request.EliminarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.request.InsertarInventarioRequestDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.EditarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.EliminarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.InsertarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.application.dto.response.ListarInventarioResponseDto;
import com.sise.polleria_proyecto.inventario.application.service.InventarioApplicationService;

// Importaciones Swagger/OpenAPI
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Inventario", description = "Gestión completa del inventario (CRUD)")
@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioApplicationService inventarioApplicationService;

    // *** 1. INSERTAR (POST) ***
    @Operation(summary = "Registra un nuevo inventario", description = "Crea un registro de inventario para un producto.")
    @ApiResponse(
        responseCode = "201",
        description = "Inventario creado exitosamente",
        content = @Content(schema = @Schema(implementation = InsertarInventarioResponseDto.class))
    )
    @ApiResponse(responseCode = "400", description = "Error de validación", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PostMapping
    public ResponseEntity<BaseResponseDto> insertarInventario(@RequestBody InsertarInventarioRequestDto requestDto) {
        try {
            InsertarInventarioResponseDto responseData = inventarioApplicationService.insertarInventario(requestDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(BaseResponseDto.success(responseData, "Inventario registrado exitosamente."));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error al registrar el inventario."));
        }
    }

    // *** 2. EDITAR (PUT) ***
    @Operation(summary = "Edita un inventario existente", description = "Actualiza la información de un registro de inventario.")
    @ApiResponse(
        responseCode = "200",
        description = "Inventario editado exitosamente",
        content = @Content(schema = @Schema(implementation = EditarInventarioResponseDto.class))
    )
    @ApiResponse(responseCode = "404", description = "Inventario no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PutMapping
    public ResponseEntity<BaseResponseDto> editarInventario(@RequestBody EditarInventarioRequestDto requestDto) {
        EditarInventarioResponseDto responseData = inventarioApplicationService.editarInventario(requestDto);

        if (responseData != null) {
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Inventario actualizado."));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(BaseResponseDto.error("El inventario a editar no fue encontrado."));
        }
    }

    // *** 3. ELIMINAR (DELETE) ***
    @Operation(summary = "Elimina un inventario por ID", description = "Elimina lógicamente un registro de inventario.")
    @ApiResponse(
        responseCode = "200",
        description = "Inventario eliminado exitosamente",
        content = @Content(schema = @Schema(implementation = EliminarInventarioResponseDto.class))
    )
    @ApiResponse(responseCode = "404", description = "Inventario no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @DeleteMapping
    public ResponseEntity<BaseResponseDto> eliminarInventario(@RequestBody EliminarInventarioRequestDto requestDto) {
        try {
            EliminarInventarioResponseDto responseData = inventarioApplicationService.eliminarInventario(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Inventario eliminado correctamente."));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error al intentar eliminar el inventario."));
        }
    }

    // *** 4. LISTAR (GET) ***
    @Operation(summary = "Lista todos los inventarios", description = "Obtiene todos los registros de inventario existentes.")
    @ApiResponse(
        responseCode = "200",
        description = "Lista de inventarios obtenida exitosamente",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = ListarInventarioResponseDto.class)))
    )
    @GetMapping
    public ResponseEntity<BaseResponseDto> listarInventarios() {
        try {
            List<ListarInventarioResponseDto> inventarios = inventarioApplicationService.listarInventarios();
            return ResponseEntity.ok(BaseResponseDto.success(inventarios, "Lista de inventarios obtenida."));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error al intentar listar los inventarios."));
        }
    }
}
