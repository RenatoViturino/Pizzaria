package com.br.pizzaria.domain.event;

import com.br.pizzaria.domain.entity.StatusPedido;
import java.time.Instant;

/**
 * Evento de domínio: Status do pedido alterado.
 * Publicado no Kafka a cada transição de estado (diagrama de estados).
 */
public record PedidoStatusAlteradoEvent(
    Long pedidoId,
    String cpfCliente,
    StatusPedido statusAnterior,
    StatusPedido novoStatus,
    Instant ocorridoEm
) {}
