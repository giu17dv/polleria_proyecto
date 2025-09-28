package com.sise.polleria_proyecto.comprobantepago.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "Respuesta devuelta al registrar un comprobante de pago.")
public class InsertarComprobantePagoResponseDto {

    @Schema(description = "ID generado para el comprobante", example = "501")
    private Integer idComprobantePago;

    @Schema(description = "ID del usuario que realiza el pago", example = "101")
    private Integer idUsuario;

    @Schema(description = "ID del pedido asociado", example = "2001")
    private Integer idPedido;

    @Schema(description = "Tipo de comprobante", example = "Boleta")
    private String tipo;

    @Schema(description = "Monto total del comprobante", example = "150.75")
    private BigDecimal montoTotal;

    @Schema(description = "Fecha y hora de emisión", example = "2025-09-27T12:30:00")
    private LocalDateTime fechaEmision;

    @Schema(description = "Fecha y hora de creación del registro", example = "2025-09-27T12:31:00")
    private LocalDateTime fechaCreacion;
}
