package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;

/**
 * DTO de resposta: Produto (substitui PizzaResponse)
 * PK: idProduto (Long) — conforme diagrama
 */
public record ProdutoResponse(
        Long idProduto,
        String nome,
        String tipo,
        BigDecimal preco,
        Integer estoqueAtual
) {}
