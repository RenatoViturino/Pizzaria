package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MovimentarEstoqueRequest(
        @NotNull Long idProduto,
        @NotBlank String tipoMovimento,
        @NotNull @Positive Integer quantidade
) {}
