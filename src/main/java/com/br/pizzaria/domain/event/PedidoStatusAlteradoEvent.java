package com.br.pizzaria.domain.event;

import com.br.pizzaria.domain.valueobject.StatusPedido;
import java.time.Instant;
import java.util.UUID;

/**
 * Evento de domínio: Status do Pedido alterado.
 */
public record PedidoStatusAlteradoEvent(
    UUID pedidoId,
    StatusPedido statusAnterior,
    StatusPedido novoStatus,
    Instant ocorridoEm
) {}
