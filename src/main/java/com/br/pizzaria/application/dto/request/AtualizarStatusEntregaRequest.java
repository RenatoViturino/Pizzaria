package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO de entrada: atualizar status da Entrega
 */
public record AtualizarStatusEntregaRequest(
        @NotNull Long idEntrega,
        @NotBlank String novoStatus
) {}
