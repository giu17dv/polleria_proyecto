package com.sise.polleria_proyecto.productos.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sise.polleria_proyecto.common.application.dto.response.BaseResponseDto;

// Importaciones de Swagger/OpenAPI
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.sise.polleria_proyecto.productos.application.dto.request.EditarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.request.EliminarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.request.InsertarProductoRequestDto;
import com.sise.polleria_proyecto.productos.application.dto.response.EditarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.dto.response.EliminarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.dto.response.InsertarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.dto.response.ListarProductoResponseDto;
import com.sise.polleria_proyecto.productos.application.service.ProductoApplicationService;

@Tag(name = "Productos", description = "Gestión completa de productos del sistema (CRUD)")
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoApplicationService productoApplicationService;

    // *** 1. INSERTAR (POST) ***
    @Operation(summary = "Registra un nuevo producto", description = "Crea un nuevo producto y devuelve el objeto creado.")
    @ApiResponse(
        responseCode = "201",
        description = "Producto creado exitosamente",
        content = @Content(
            schema = @Schema(implementation = InsertarProductoResponseDto.class)
        )
    )
    @ApiResponse(responseCode = "400", description = "Error de validación de campos", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PostMapping
    public ResponseEntity<BaseResponseDto> insertarProducto(@RequestBody InsertarProductoRequestDto requestDto) {
        try {
            InsertarProductoResponseDto responseData = productoApplicationService.insertarProducto(requestDto);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(BaseResponseDto.success(responseData, "Producto registrado exitosamente."));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al registrar el producto."));
        }
    }

    // *** 2. EDITAR (PUT) ***
    @Operation(summary = "Actualiza la información de un producto existente", description = "Busca el producto por ID y actualiza sus campos.")
    @ApiResponse(
        responseCode = "200",
        description = "Producto editado exitosamente",
        content = @Content(
            schema = @Schema(implementation = EditarProductoResponseDto.class)
        )
    )
    @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error de validación de campos", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @PutMapping
    public ResponseEntity<BaseResponseDto> editarProducto(@RequestBody EditarProductoRequestDto requestDto) {
        EditarProductoResponseDto responseData = productoApplicationService.editarProducto(requestDto);

        if (responseData != null) {
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Producto actualizado."));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(BaseResponseDto.error("El producto a editar no fue encontrado."));
        }
    }

    // *** 3. ELIMINAR (DELETE) ***
    @Operation(summary = "Elimina un producto por ID", description = "Elimina lógicamente un producto del sistema y devuelve la confirmación.")
    @ApiResponse(
        responseCode = "200",
        description = "Producto eliminado exitosamente",
        content = @Content(
            schema = @Schema(implementation = EliminarProductoResponseDto.class)
        )
    )
    @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @DeleteMapping
    public ResponseEntity<BaseResponseDto> eliminarProducto(@RequestBody EliminarProductoRequestDto requestDto) {
        try {
            EliminarProductoResponseDto responseData = productoApplicationService.eliminarProducto(requestDto);
            return ResponseEntity.ok(BaseResponseDto.success(responseData, "Producto eliminado correctamente."));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error interno al intentar eliminar el producto."));
        }
    }

    // *** 4. LISTAR (GET) ***
    @Operation(summary = "Obtiene la lista de todos los productos", description = "Devuelve una lista de todos los productos disponibles en el sistema.")
    @ApiResponse(
        responseCode = "200",
        description = "Lista de productos obtenida exitosamente",
        content = @Content(
            array = @ArraySchema(schema = @Schema(implementation = ListarProductoResponseDto.class))
        )
    )
    @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(schema = @Schema(implementation = BaseResponseDto.class)))
    @GetMapping
    public ResponseEntity<BaseResponseDto> listarProductos() {
        try {
            List<ListarProductoResponseDto> productos = productoApplicationService.listarProductos();
            return ResponseEntity.ok(BaseResponseDto.success(productos, "Lista de productos obtenida."));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BaseResponseDto.error("Ocurrió un error al intentar listar los productos."));
        }
    }
}
