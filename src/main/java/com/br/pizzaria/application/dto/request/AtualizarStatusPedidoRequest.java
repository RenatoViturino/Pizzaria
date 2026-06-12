package com.br.pizzaria.application.dto.request;

import com.br.pizzaria.domain.valueobject.StatusPedido;
import java.util.UUID;

/**
 * DTO de entrada: Atualizar Status do Pedido.
 */
public record AtualizarStatusPedidoRequest(
    UUID pedidoId,
    StatusPedido novoStatus
) {}
