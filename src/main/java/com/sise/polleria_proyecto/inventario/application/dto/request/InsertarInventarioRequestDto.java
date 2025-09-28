package com.sise.polleria_proyecto.inventario.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos para insertar un nuevo registro de inventario.")
public class InsertarInventarioRequestDto {

    @NotNull(message = "El ID del producto es obligatorio")
    @Schema(description = "Identificador único del producto asociado al inventario.", example = "12")
    private Integer idProducto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    @Schema(description = "Cantidad actual del producto en inventario.", example = "150")
    private Integer cantidad;

    @NotNull(message = "El stock mínimo es obligatorio")
    @Min(value = 0, message = "El stock mínimo no puede ser negativo")
    @Schema(description = "Stock mínimo permitido antes de generar alerta.", example = "10")
    private Integer stockMinimo;

    @Schema(description = "Ubicación física del producto en el almacén.", example = "Almacén A - Estante 3")
    private String ubicacion;
}
