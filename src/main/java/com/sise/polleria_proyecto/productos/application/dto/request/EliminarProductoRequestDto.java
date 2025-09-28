package com.sise.polleria_proyecto.productos.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO de solicitud para eliminar un producto.")
public class EliminarProductoRequestDto {

    @Schema(description = "ID del producto a eliminar.", example = "10")
    private Integer idProducto;
}
