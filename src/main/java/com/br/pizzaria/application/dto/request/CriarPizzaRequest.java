package com.br.pizzaria.application.dto.request;

import java.math.BigDecimal;

/**
 * DTO de entrada: Criar Pizza.
 */
public record CriarPizzaRequest(
    String nome,
    String descricao,
    BigDecimal preco,
    String tamanho
) {}
