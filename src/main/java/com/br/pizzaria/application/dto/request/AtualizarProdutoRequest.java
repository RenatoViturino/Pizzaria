package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record AtualizarProdutoRequest(
        String nome,
        String tipo,
        @PositiveOrZero BigDecimal preco,
        @PositiveOrZero Integer estoqueAtual
) {}
