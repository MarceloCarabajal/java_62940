package com.coderhouse.finalEcommerce.dto;

import com.coderhouse.finalEcommerce.entity.Producto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(description = "Modelo de Compra DTO", title = "Compra DTO")
public class CompraDTO {

    @Schema(description = "Cliente ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long clienteId;

    @Schema(description = "Producto ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private List<Long> productosId;
}
