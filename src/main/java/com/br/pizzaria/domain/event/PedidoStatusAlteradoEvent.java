package com.br.pizzaria.domain.event;

import com.br.pizzaria.domain.valueobject.StatusPedido;

import java.time.LocalDateTime;

/**
 * Evento de domínio: PedidoStatusAlterado
 * Publicado via Kafka quando o status de um pedido muda.
 */
public record PedidoStatusAlteradoEvent(
        Long idPedido,
        String cpfCliente,
        StatusPedido statusAnterior,
        StatusPedido novoStatus,
        LocalDateTime dataHora
) {}
