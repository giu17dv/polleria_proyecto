package com.sise.polleria_proyecto.comprobantepago.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Datos necesarios para eliminar un comprobante de pago por su ID.")
public class EliminarComprobantePagoRequestDto {

    @NotNull(message = "El ID del comprobante es obligatorio")
    @Schema(description = "Identificador único del comprobante a eliminar", example = "501")
    private Integer idComprobantePago;

    @Schema(description = "Nuevo estado del comprobante (opcional)", example = "ANULADO")
    private String estado;
}
