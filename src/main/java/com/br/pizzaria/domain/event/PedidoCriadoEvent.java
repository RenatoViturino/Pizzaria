package com.br.pizzaria.domain.event;

import java.time.Instant;

/**
 * Evento de domínio: Pedido criado.
 * Publicado no Kafka via EventPublisher (infraestrutura).
 * Alinhado ao modelo de domínio: cpfCliente como identificador de Cliente.
 */
public record PedidoCriadoEvent(
    Long pedidoId,         // PK de Pedido (Long)
    String cpfCliente,     // PK de Cliente (String) — era UUID clienteId, corrigido
    Instant ocorridoEm
) {}
