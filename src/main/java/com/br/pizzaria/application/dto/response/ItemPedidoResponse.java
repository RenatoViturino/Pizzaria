package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;

public record ItemPedidoResponse(
        Long idItem,
        Long idProduto,
        Integer quantidade,
        BigDecimal precoUnitario,
        BigDecimal subtotal
) {}
