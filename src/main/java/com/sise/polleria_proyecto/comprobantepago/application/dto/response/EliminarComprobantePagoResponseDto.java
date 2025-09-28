package com.sise.polleria_proyecto.comprobantepago.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Respuesta de la eliminación de un comprobante de pago.")
public class EliminarComprobantePagoResponseDto {

    @Schema(description = "ID del comprobante eliminado", example = "501")
    private Integer idComprobantePago;

    @Schema(description = "ID del usuario asociado", example = "101")
    private Integer idUsuario;

    @Schema(description = "Estado final del comprobante", example = "ANULADO")
    private String estado;

    @Schema(description = "Mensaje de confirmación", example = "El comprobante ha sido anulado correctamente.")
    private String mensajeConfirmacion;
}
