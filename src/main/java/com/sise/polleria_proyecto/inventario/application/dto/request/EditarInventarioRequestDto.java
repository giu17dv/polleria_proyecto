package com.sise.polleria_proyecto.inventario.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos para actualizar un registro de inventario existente.")
public class EditarInventarioRequestDto {

    @NotNull(message = "El ID del inventario es obligatorio para la edición")
    @Schema(description = "Identificador único del inventario a editar.", example = "101")
    private Integer idInventario;

    @Schema(description = "Nuevo ID del producto asociado (Opcional).", example = "12", nullable = true)
    private Integer idProducto;

    @Min(value = 0, message = "La cantidad no puede ser negativa")
    @Schema(description = "Nueva cantidad del producto en inventario (Opcional).", example = "200", nullable = true)
    private Integer cantidad;

    @Min(value = 0, message = "El stock mínimo no puede ser negativo")
    @Schema(description = "Nuevo stock mínimo (Opcional).", example = "20", nullable = true)
    private Integer stockMinimo;

    @Schema(description = "Nueva ubicación del producto en almacén (Opcional).", example = "Almacén B - Estante 2", nullable = true)
    private String ubicacion;
}
