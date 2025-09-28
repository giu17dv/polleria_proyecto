package com.sise.polleria_proyecto.comprobantepago.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "Datos necesarios para registrar un nuevo comprobante de pago.")
public class InsertarComprobantePagoRequestDto {

    @NotNull(message = "El ID del usuario es obligatorio")
    @Schema(description = "Identificador del usuario que realiza el pago", example = "101")
    private Integer idUsuario;

    @NotNull(message = "El ID del pedido es obligatorio")
    @Schema(description = "Identificador del pedido asociado", example = "2001")
    private Integer idPedido;

    @NotNull(message = "El tipo de comprobante es obligatorio")
    @Size(max = 20)
    @Schema(description = "Tipo de comprobante (Boleta, Factura, Ticket, etc.)", example = "Boleta")
    private String tipo;

    @NotNull(message = "El monto total es obligatorio")
    @DecimalMin(value = "0.01", message = "El monto total debe ser mayor a 0")
    @Schema(description = "Monto total del comprobante", example = "150.75")
    private BigDecimal montoTotal;

    @NotNull(message = "La fecha de emisión es obligatoria")
    @Schema(description = "Fecha y hora de emisión del comprobante", example = "2025-09-27T12:30:00")
    private LocalDateTime fechaEmision;
}
