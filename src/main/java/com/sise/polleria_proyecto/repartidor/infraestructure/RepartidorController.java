package com.sise.polleria_proyecto.repartidor.infraestructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.polleria_proyecto.common.application.dto.response.BaseResponseDto;
import com.sise.polleria_proyecto.repartidor.application.dto.request.EditarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.request.EliminarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.request.InsertarRepartidorRequestDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.EditarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.EliminarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.InsertarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.application.dto.response.ListarRepartidorResponseDto;
import com.sise.polleria_proyecto.repartidor.application.service.RepartidorApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Repartidores", description = "Gestión completa de repartidores del sistema (CRUD)")
@RestController
@RequestMapping("/repartidor")
public class RepartidorController {

    @Autowired
    private RepartidorApplicationService repartidorApplicationService;

    // *** 1. INSERTAR ***
    @Operation(summary = "Registra un nuevo repartidor en el sistema", description = "Crea un nuevo repartidor y devuelve el objeto creado.")
    @ApiResponse(responseCode = "201", description = "Repartidor creado exitosamente",
            content = @Content(schema = @Schema(implementation = InsertarRepartidorResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PostMapping
    public ResponseEntity<BaseResponseDto> insertarRepartidor(@RequestBody InsertarRepartidorRequestDto requestDto) {
        try {
            InsertarRepartidorResponseDto responseData = repartidorApplicationService.insertarRepartidor(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponseDto.success(responseData, "Repartidor registrado exitosamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al registrar el repartidor."));
        }
    }

    // *** 2. EDITAR ***
    @Operation(summary = "Actualiza la información de un repartidor existente", description = "Busca el repartidor por ID y actualiza sus campos.")
    @ApiResponse(responseCode = "200", description = "Repartidor editado exitosamente",
            content = @Content(schema = @Schema(implementation = EditarRepartidorResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Repartidor no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PutMapping
    public ResponseEntity<BaseResponseDto> editarRepartidor(@RequestBody EditarRepartidorRequestDto requestDto) {
        EditarRepartidorResponseDto responseData = repartidorApplicationService.editarRepartidor(requestDto);
        if (responseData != null) {
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Repartidor actualizado."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseResponseDto.error("El repartidor a editar no fue encontrado."));
        }
    }

    // *** 3. ELIMINAR ***
    @Operation(summary = "Elimina un repartidor por ID", description = "Elimina lógicamente un repartidor del sistema y devuelve la confirmación.")
    @ApiResponse(responseCode = "200", description = "Repartidor eliminado exitosamente",
            content = @Content(schema = @Schema(implementation = EliminarRepartidorResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Repartidor no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @DeleteMapping
    public ResponseEntity<BaseResponseDto> eliminarRepartidor(@RequestBody EliminarRepartidorRequestDto requestDto) {
        try {
            EliminarRepartidorResponseDto responseData = repartidorApplicationService.eliminarRepartidor(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Repartidor eliminado correctamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al intentar eliminar el repartidor."));
        }
    }

    // *** 4. LISTAR ***
    @Operation(summary = "Obtiene la lista de todos los repartidores", description = "Devuelve una lista de todos los repartidores activos del sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de repartidores obtenida exitosamente",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ListarRepartidorResponseDto.class))))
    @ApiResponse(responseCode = "500", description = "Error interno", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @GetMapping
    public ResponseEntity<BaseResponseDto> listarRepartidores() {
        try {
            List<ListarRepartidorResponseDto> repartidores = repartidorApplicationService.listarRepartidores();
            return ResponseEntity.ok(BaseResponseDto.success(repartidores, "Lista de repartidores obtenida."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error al intentar listar los repartidores."));
        }
    }
}
