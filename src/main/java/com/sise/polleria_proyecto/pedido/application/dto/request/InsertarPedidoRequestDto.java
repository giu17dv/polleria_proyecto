package com.sise.polleria_proyecto.pedido.application.dto.request;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos para crear un nuevo pedido.")
public class InsertarPedidoRequestDto {

    @NotNull(message = "El ID del usuario es obligatorio")
    @Schema(description = "Identificador del usuario que realiza el pedido.", example = "12")
    private Integer idUsuario;

    @NotNull(message = "La fecha y hora del pedido es obligatoria")
    @Schema(description = "Fecha y hora en que se realiza el pedido.", example = "2025-09-27T18:30:00")
    private String fechaHoraPedido;

    @NotNull(message = "El estado es obligatorio")
    @Schema(description = "Estado inicial del pedido.", example = "PENDIENTE")
    private String estado;

    @NotNull(message = "El total del pedido es obligatorio")
    @Schema(description = "Monto total del pedido.", example = "120.50")
    private Double total;

    @Schema(description = "Fecha de creación del pedido.", example = "2025-09-27T18:31:00")
    private String fechaCreacion;
}

