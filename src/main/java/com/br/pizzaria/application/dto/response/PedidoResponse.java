package com.br.pizzaria.application.dto.response;

import com.br.pizzaria.domain.valueobject.StatusPedido;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO de saída: Pedido.
 */
public record PedidoResponse(
    UUID id,
    UUID clienteId,
    StatusPedido status,
    Instant criadoEm
) {}
