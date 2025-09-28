package com.sise.polleria_proyecto.comprobantepago.infraestructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sise.polleria_proyecto.common.application.dto.response.BaseResponseDto;

// Swagger/OpenAPI
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.sise.polleria_proyecto.comprobantepago.application.dto.request.EditarComprobantePagoRequestDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.request.EliminarComprobantePagoRequestDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.request.InsertarComprobantePagoRequestDto;

import com.sise.polleria_proyecto.comprobantepago.application.dto.response.EditarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.EliminarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.InsertarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.application.dto.response.ListarComprobantePagoResponseDto;
import com.sise.polleria_proyecto.comprobantepago.application.service.ComprobantePagoApplicationService;

@Tag(name = "Comprobantes de Pago", description = "Gestión completa de comprobantes de pago (CRUD)")
@RestController
@RequestMapping("/comprobante-pago")
public class ComprobantePagoController {

    @Autowired
    private ComprobantePagoApplicationService comprobantePagoService;

    // *** 1. INSERTAR ***
    @Operation(summary = "Registra un nuevo comprobante de pago", description = "Crea un nuevo comprobante y devuelve el objeto creado.")
    @ApiResponse(responseCode = "201", description = "Comprobante creado exitosamente",
                 content = @Content(schema = @Schema(implementation = InsertarComprobantePagoResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PostMapping
    public ResponseEntity<BaseResponseDto> insertarComprobantePago(
            @RequestBody InsertarComprobantePagoRequestDto requestDto) {
        try {
            InsertarComprobantePagoResponseDto responseData = comprobantePagoService.insertarComprobantePago(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(BaseResponseDto.success(responseData, "Comprobante registrado exitosamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al registrar el comprobante."));
        }
    }

    // *** 2. EDITAR ***
    @Operation(summary = "Actualiza un comprobante de pago existente", description = "Actualiza los campos del comprobante por ID.")
    @ApiResponse(responseCode = "200", description = "Comprobante editado exitosamente",
                 content = @Content(schema = @Schema(implementation = EditarComprobantePagoResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Comprobante no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PutMapping
    public ResponseEntity<BaseResponseDto> editarComprobantePago(@RequestBody EditarComprobantePagoRequestDto requestDto) {
        EditarComprobantePagoResponseDto responseData = comprobantePagoService.editarComprobantePago(requestDto);
        if (responseData != null) {
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Comprobante actualizado."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(BaseResponseDto.error("El comprobante a editar no fue encontrado."));
        }
    }

    // *** 3. ELIMINAR ***
    @Operation(summary = "Elimina un comprobante de pago por ID", description = "Elimina lógicamente un comprobante del sistema.")
    @ApiResponse(responseCode = "200", description = "Comprobante eliminado exitosamente",
                 content = @Content(schema = @Schema(implementation = EliminarComprobantePagoResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Comprobante no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @DeleteMapping
    public ResponseEntity<BaseResponseDto> eliminarComprobantePago(@RequestBody EliminarComprobantePagoRequestDto requestDto) {
        try {
            EliminarComprobantePagoResponseDto responseData = comprobantePagoService.eliminarComprobantePago(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Comprobante eliminado correctamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al intentar eliminar el comprobante."));
        }
    }

    // *** 4. LISTAR ***
    @Operation(summary = "Obtiene la lista de todos los comprobantes de pago", description = "Devuelve una lista de todos los comprobantes registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de comprobantes obtenida exitosamente",
                 content = @Content(array = @ArraySchema(schema = @Schema(implementation = ListarComprobantePagoResponseDto.class))))
    @ApiResponse(responseCode = "500", description = "Error interno", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @GetMapping
    public ResponseEntity<BaseResponseDto> listarComprobantesPago() {
        try {
            List<ListarComprobantePagoResponseDto> comprobantes = comprobantePagoService.listarComprobantesPago();
            return ResponseEntity.ok(BaseResponseDto.success(comprobantes, "Lista de comprobantes obtenida."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error al intentar listar los comprobantes."));
        }
    }
}
