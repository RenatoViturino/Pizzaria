package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

/**
 * DTO de entrada: atualizar Produto (campos opcionais)
 */
public record AtualizarProdutoRequest(
        String nome,
        String tipo,
        @DecimalMin("0.01") BigDecimal preco
) {}
