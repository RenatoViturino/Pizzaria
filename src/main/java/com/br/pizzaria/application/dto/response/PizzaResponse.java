package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO de saída: Pizza.
 */
public record PizzaResponse(
    UUID id,
    String nome,
    String descricao,
    BigDecimal preco,
    String tamanho
) {}
