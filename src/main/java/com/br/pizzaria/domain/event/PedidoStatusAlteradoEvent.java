package com.br.pizzaria.domain.event;

import com.br.pizzaria.domain.valueobject.StatusPedido;
import java.time.LocalDateTime;

/**
 * Evento de domínio: Status do pedido alterado.
 * Publicado no Kafka a cada transição de estado.
 * Import corrigido: StatusPedido está em domain.valueobject (não domain.entity).
 */
public record PedidoStatusAlteradoEvent(
    Long idPedido,
    String cpfCliente,
    StatusPedido statusAnterior,
    StatusPedido novoStatus,
    LocalDateTime dataHora
) {}
