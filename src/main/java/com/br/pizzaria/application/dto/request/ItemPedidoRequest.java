package com.br.pizzaria.application.dto.request;

import java.util.UUID;

/**
 * DTO de entrada: Item do Pedido.
 */
public record ItemPedidoRequest(
    UUID pizzaId,
    int quantidade
) {}
