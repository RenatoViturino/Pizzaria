package com.br.pizzaria.domain.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Evento de domínio: PedidoCriado
 * Publicado via Kafka quando um novo pedido é confirmado.
 */
public record PedidoCriadoEvent(
        Long idPedido,
        String cpfCliente,
        BigDecimal valorTotal,
        LocalDateTime dataHora
) {}
