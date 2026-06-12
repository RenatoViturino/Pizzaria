package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.*;

/**
 * DTO de entrada: atualizar status do Pedido
 * idPedido é Long — conforme diagrama
 */
public record AtualizarStatusPedidoRequest(
        @NotNull Long idPedido,
        @NotBlank String novoStatus
) {}
