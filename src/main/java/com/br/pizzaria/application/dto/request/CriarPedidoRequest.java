package com.br.pizzaria.application.dto.request;

import java.util.List;
import java.util.UUID;

/**
 * DTO de entrada: Criar Pedido.
 */
public record CriarPedidoRequest(
    UUID clienteId,
    List<ItemPedidoRequest> itens,
    String enderecoEntrega
) {}
