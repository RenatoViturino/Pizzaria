package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AvaliarEntregaRequest(
        @NotNull Long idEntrega,
        @NotNull @Min(1) @Max(5) Integer avaliacaoCliente,
        @NotNull @Min(1) @Max(5) Integer avaliacaoEntregador
) {}
