package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CriarProdutoRequest(
        @NotBlank String nome,
        @NotBlank String tipo,
        @NotNull @PositiveOrZero BigDecimal preco,
        @NotNull @PositiveOrZero Integer estoqueAtual
) {}
