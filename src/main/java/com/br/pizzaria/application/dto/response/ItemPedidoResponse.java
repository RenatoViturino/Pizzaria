package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;

/**
 * DTO de resposta: ItemPedido
 * PK: idItem (Long) — conforme diagrama
 */
public record ItemPedidoResponse(
        Long idItem,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal subtotal,
        Long idProduto,
        String nomeProduto
) {}
