package com.sise.polleria_proyecto.pedido.infraestructure;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.polleria_proyecto.common.application.dto.response.BaseResponseDto;
import com.sise.polleria_proyecto.pedido.application.dto.request.EditarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.request.EliminarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.request.InsertarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.EditarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.EliminarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.InsertarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.ListarPedidoResponseDto;
// Servicio de aplicación
import com.sise.polleria_proyecto.pedido.application.service.PedidoApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pedidos", description = "Gestión completa de pedidos del sistema (CRUD)")
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoApplicationService pedidoApplicationService;

    // *** 1. CREAR (POST) ***
    @Operation(summary = "Registra un nuevo pedido en el sistema", description = "Crea un nuevo pedido y devuelve el objeto creado.")
    @ApiResponse(
        responseCode = "201",
        description = "Pedido creado exitosamente",
        content = @Content(schema = @Schema(implementation = InsertarPedidoResponseDto.class))
    )
    @ApiResponse(responseCode = "400", description = "Error de validación de campos", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PostMapping
    public ResponseEntity<BaseResponseDto> crearPedido(@RequestBody InsertarPedidoRequestDto requestDto) {
        try {
            InsertarPedidoResponseDto responseData = pedidoApplicationService.insertarPedido(requestDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(BaseResponseDto.success(responseData, "Pedido registrado exitosamente."));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al registrar el pedido."));
        }
    }

    // *** 2. EDITAR (PUT) ***
    @Operation(summary = "Actualiza la información de un pedido existente", description = "Busca el pedido por ID y actualiza sus campos.")
    @ApiResponse(
        responseCode = "200",
        description = "Pedido editado exitosamente",
        content = @Content(schema = @Schema(implementation = EditarPedidoResponseDto.class))
    )
    @ApiResponse(responseCode = "404", description = "Pedido no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de campos", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PutMapping
    public ResponseEntity<BaseResponseDto> editarPedido(@RequestBody EditarPedidoRequestDto requestDto) {
        EditarPedidoResponseDto responseData = pedidoApplicationService.editarPedido(requestDto);

        if (responseData != null) {
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Pedido actualizado."));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(BaseResponseDto.error("El pedido a editar no fue encontrado."));
        }
    }

    // *** 3. ELIMINAR (DELETE) ***
    @Operation(summary = "Elimina un pedido por ID", description = "Elimina lógicamente un pedido del sistema y devuelve la confirmación.")
    @ApiResponse(
        responseCode = "200",
        description = "Pedido eliminado exitosamente",
        content = @Content(schema = @Schema(implementation = EliminarPedidoResponseDto.class))
    )
    @ApiResponse(responseCode = "404", description = "Pedido no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @DeleteMapping
    public ResponseEntity<BaseResponseDto> eliminarPedido(@RequestBody EliminarPedidoRequestDto requestDto) {
        try {
            EliminarPedidoResponseDto responseData = pedidoApplicationService.eliminarPedido(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Pedido eliminado correctamente."));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al intentar eliminar el pedido."));
        }
    }

    // *** 4. LISTAR (GET) ***
    @Operation(summary = "Obtiene la lista de todos los pedidos", description = "Devuelve una lista de todos los pedidos registrados.")
    @ApiResponse(
        responseCode = "200",
        description = "Lista de pedidos obtenida exitosamente",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = ListarPedidoResponseDto.class)))
    )
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @GetMapping
    public ResponseEntity<BaseResponseDto> listarPedidos() {
        try {
            List<ListarPedidoResponseDto> pedidos = pedidoApplicationService.listarPedido();
            return ResponseEntity.ok(BaseResponseDto.success(pedidos, "Lista de pedidos obtenida."));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error al intentar listar los pedidos."));
        }
    }
}
