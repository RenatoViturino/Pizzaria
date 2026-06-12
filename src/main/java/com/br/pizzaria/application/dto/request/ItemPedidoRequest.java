package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.*;

/**
 * DTO de entrada: item de pedido
 * idProduto referencia PK Long do produto
 */
public record ItemPedidoRequest(
        @NotNull Long idProduto,
        @NotNull @Min(1) Integer quantidade
) {}
