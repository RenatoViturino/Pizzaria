package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 * DTO de entrada: criar Produto (substitui CriarPizzaRequest)
 */
public record CriarProdutoRequest(
        @NotBlank String nome,
        @NotBlank String tipo,
        @NotNull @DecimalMin("0.01") BigDecimal preco,
        @NotNull @Min(0) Integer estoqueAtual
) {}
