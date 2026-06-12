package com.br.pizzaria.domain.event;

import java.time.Instant;
import java.util.UUID;

/**
 * Evento de domínio: Pedido criado.
 * Publicado no Kafka via infraestrutura.
 */
public record PedidoCriadoEvent(
    UUID pedidoId,
    UUID clienteId,
    Instant ocorridoEm
) {}
