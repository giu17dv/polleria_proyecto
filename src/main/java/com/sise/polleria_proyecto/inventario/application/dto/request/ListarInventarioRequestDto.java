package com.sise.polleria_proyecto.inventario.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO vacío para listar todos los inventarios. Si se implementa filtrado o paginación, los campos se agregarían aquí.")
public class ListarInventarioRequestDto {
}
