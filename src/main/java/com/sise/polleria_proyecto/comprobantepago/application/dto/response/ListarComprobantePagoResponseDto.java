package com.sise.polleria_proyecto.comprobantepago.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "Modelo de datos de un comprobante devuelto en la lista de consulta.")
public class ListarComprobantePagoResponseDto {

    @Schema(description = "ID del comprobante", example = "501")
    private Integer idComprobantePago;

    @Schema(description = "ID del usuario asociado", example = "101")
    private Integer idUsuario;

    @Schema(description = "ID del pedido asociado", example = "2001")
    private Integer idPedido;

    @Schema(description = "Tipo de comprobante", example = "Boleta")
    private String tipo;

    @Schema(description = "Monto total del comprobante", example = "150.75")
    private BigDecimal montoTotal;

    @Schema(description = "Fecha de emisión", example = "2025-09-27T12:30:00")
    private LocalDateTime fechaEmision;

    @Schema(description = "Fecha de creación del registro", example = "2025-09-27T12:31:00")
    private LocalDateTime fechaCreacion;

    @Schema(description = "Fecha de modificación del registro", example = "2025-09-27T13:00:00", nullable = true)
    private LocalDateTime fechaModificacion;
}
