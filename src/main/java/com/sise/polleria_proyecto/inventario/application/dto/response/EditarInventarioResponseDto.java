package com.sise.polleria_proyecto.inventario.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta después de editar un inventario.")
public class EditarInventarioResponseDto {

    @Schema(description = "Identificador único del inventario editado.", example = "101")
    private Integer idInventario;

    @Schema(description = "Identificador del producto asociado al inventario.", example = "301")
    private Integer idProducto;

    @Schema(description = "Cantidad actualizada en el inventario.", example = "150")
    private Integer cantidad;

    @Schema(description = "Stock mínimo requerido para el inventario.", example = "20")
    private Integer stockMinimo;

    @Schema(description = "Ubicación del inventario en el almacén.", example = "Estante A3")
    private String ubicacion;

    @Schema(description = "Fecha de la última actualización del inventario.", example = "2025-09-27T18:45:00")
    private String fechaModificacion;      

    @Schema(description = "Mensaje de confirmación.", example = "Inventario actualizado exitosamente.")
    private String mensaje;
}
