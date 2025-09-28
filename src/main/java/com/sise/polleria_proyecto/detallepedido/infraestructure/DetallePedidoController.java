package com.sise.polleria_proyecto.detallepedido.infraestructure;

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

import com.sise.polleria_proyecto.detallepedido.application.dto.request.EditarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.EliminarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.InsertarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.EditarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.EliminarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.InsertarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.ListarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.service.DetallePedidoApplicationService;

@Tag(name = "DetallePedidos", description = "Gestión completa de los detalles de pedidos (CRUD)")
@RestController
@RequestMapping("/detalle-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoApplicationService detallePedidoApplicationService;

    // *** 1. INSERTAR (POST) ***
    @Operation(summary = "Registra un nuevo detalle de pedido", description = "Crea un nuevo detalle de pedido y devuelve el objeto creado.")
    @ApiResponse(responseCode = "201", description = "Detalle de pedido creado exitosamente",
        content = @Content(schema = @Schema(implementation = InsertarDetallePedidoResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de campos", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PostMapping
    public ResponseEntity<BaseResponseDto> insertarDetallePedido(@RequestBody InsertarDetallePedidoRequestDto requestDto) {
        try {
            InsertarDetallePedidoResponseDto responseData = detallePedidoApplicationService.insertarDetallePedido(requestDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body(BaseResponseDto.success(responseData, "Detalle de pedido registrado exitosamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(BaseResponseDto.error("Ocurrió un error interno al registrar el detalle de pedido."));
        }
    }

    // *** 2. EDITAR (PUT) ***
    @Operation(summary = "Actualiza un detalle de pedido existente", description = "Actualiza los campos de un detalle de pedido identificado por su ID.")
    @ApiResponse(responseCode = "200", description = "Detalle de pedido editado exitosamente",
        content = @Content(schema = @Schema(implementation = EditarDetallePedidoResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Detalle de pedido no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PutMapping
    public ResponseEntity<BaseResponseDto> editarDetallePedido(@RequestBody EditarDetallePedidoRequestDto requestDto) {
        EditarDetallePedidoResponseDto responseData = detallePedidoApplicationService.editarDetallePedido(requestDto);
        if (responseData != null) {
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Detalle de pedido actualizado."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(BaseResponseDto.error("El detalle de pedido a editar no fue encontrado."));
        }
    }

    // *** 3. ELIMINAR (DELETE) ***
    @Operation(summary = "Elimina un detalle de pedido por ID", description = "Elimina lógicamente un detalle de pedido y devuelve la confirmación.")
    @ApiResponse(responseCode = "200", description = "Detalle de pedido eliminado exitosamente",
        content = @Content(schema = @Schema(implementation = EliminarDetallePedidoResponseDto.class)))
    @ApiResponse(responseCode = "404", description = "Detalle de pedido no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @DeleteMapping
    public ResponseEntity<BaseResponseDto> eliminarDetallePedido(@RequestBody EliminarDetallePedidoRequestDto requestDto) {
        try {
            EliminarDetallePedidoResponseDto responseData = detallePedidoApplicationService.eliminarDetallePedido(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Detalle de pedido eliminado correctamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(BaseResponseDto.error("Ocurrió un error interno al intentar eliminar el detalle de pedido."));
        }
    }

    // *** 4. LISTAR (GET) ***
    @Operation(summary = "Obtiene la lista de todos los detalles de pedidos", description = "Devuelve una lista de todos los detalles de pedidos registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de detalles de pedidos obtenida exitosamente",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = ListarDetallePedidoResponseDto.class))))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @GetMapping
    public ResponseEntity<BaseResponseDto> listarDetallePedidos() {
        try {
            List<ListarDetallePedidoResponseDto> detalles = detallePedidoApplicationService.listarDetallePedidos();
            return ResponseEntity.ok(BaseResponseDto.success(detalles, "Lista de detalles de pedidos obtenida."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(BaseResponseDto.error("Ocurrió un error al intentar listar los detalles de pedidos."));
        }
    }
}
