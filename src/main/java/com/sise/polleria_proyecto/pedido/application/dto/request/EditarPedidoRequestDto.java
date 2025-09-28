package com.sise.polleria_proyecto.pedido.application.dto.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos para actualizar la información de un pedido existente.")
public class EditarPedidoRequestDto {

    @NotNull(message = "El ID del pedido es obligatorio para la edición")
    @Schema(description = "Identificador único del pedido a editar.", example = "101")
    private Integer idPedido;

    @Schema(description = "Nuevo ID de usuario asociado al pedido (Opcional).", example = "15", nullable = true)
    private Integer idUsuario;

    @Schema(description = "Nueva fecha y hora del pedido (Opcional).", example = "2025-09-27T19:00:00", nullable = true)
    private LocalDateTime fechaHoraPedido;

    @Schema(description = "Nuevo estado del pedido (Opcional).", example = "EN_PROCESO", nullable = true)
    private String estado;

    @Schema(description = "Nuevo total del pedido (Opcional).", example = "150.00", nullable = true)
    private Double total;
}
