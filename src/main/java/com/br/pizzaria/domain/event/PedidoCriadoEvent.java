package com.br.pizzaria.domain.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Evento de domínio: Pedido criado.
 * Publicado no Kafka via PedidoEventProducer.
 * Campos alinhados ao que PedidoService passa: idPedido, cpfCliente, valorTotal, dataHora.
 */
public record PedidoCriadoEvent(
    Long idPedido,
    String cpfCliente,
    BigDecimal valorTotal,
    LocalDateTime dataHora
) {}
