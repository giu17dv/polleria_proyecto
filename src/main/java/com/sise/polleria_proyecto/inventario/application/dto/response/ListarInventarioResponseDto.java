package com.sise.polleria_proyecto.inventario.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;



@Data
@Schema(description = "Respuesta con la lista de inventarios.")
public class ListarInventarioResponseDto {

    @Schema(description = "Identificador único del inventario.", example = "101")
    private Integer idInventario;

    @Schema(description = "ID del producto asociado.", example = "12")
    private Integer idProducto;

    @Schema(description = "Cantidad actual en inventario.", example = "150")
    private Integer cantidad;

    @Schema(description = "Stock mínimo configurado.", example = "10")
    private Integer stockMinimo;

    @Schema(description = "Ubicación física del producto.", example = "Almacén A - Estante 3")
    private String ubicacion;

    @Schema(description = "Fecha de creación del registro.")
    private String fechaCreacion;

    @Schema(description = "Fecha de última modificación del registro.")
    private String fechaModificacion;
}
