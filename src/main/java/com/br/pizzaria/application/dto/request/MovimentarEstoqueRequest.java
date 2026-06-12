package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO de entrada: movimentar estoque (ENTRADA / SAIDA / AJUSTE)
 */
public record MovimentarEstoqueRequest(
        @NotNull Long idProduto,
        @NotBlank String tipoMovimento,
        @NotNull @Min(1) Integer quantidade
) {}
