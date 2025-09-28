package com.sise.polleria_proyecto.comprobantepago.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "Datos para actualizar un comprobante de pago existente.")
public class EditarComprobantePagoRequestDto {

    @NotNull(message = "El ID del comprobante es obligatorio")
    @Schema(description = "Identificador único del comprobante a editar", example = "501")
    private Integer idComprobantePago;

    @Schema(description = "Nuevo ID de usuario (opcional)", example = "102", nullable = true)
    private Integer idUsuario;

    @Schema(description = "Nuevo ID de pedido (opcional)", example = "2002", nullable = true)
    private Integer idPedido;

    @Schema(description = "Nuevo tipo de comprobante (opcional)", example = "Factura", nullable = true)
    private String tipo;

    @Schema(description = "Nuevo monto total (opcional)", example = "200.50", nullable = true)
    private BigDecimal montoTotal;

    @Schema(description = "Nueva fecha de emisión (opcional)", example = "2025-09-28T15:00:00", nullable = true)
    private LocalDateTime fechaEmision;
}

