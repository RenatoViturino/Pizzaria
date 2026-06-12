package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO de resposta: Pedido
 * PK: idPedido (Long) — conforme diagrama
 */
public record PedidoResponse(
        Long idPedido,
        LocalDateTime dataHora,
        String status,
        BigDecimal valorTotal,
        String cpfCliente,
        List<ItemPedidoResponse> itens
) {}
