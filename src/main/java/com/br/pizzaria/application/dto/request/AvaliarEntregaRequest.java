package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * DTO de entrada: avaliar uma Entrega (cliente e/ou entregador)
 */
public record AvaliarEntregaRequest(
        @NotNull Long idEntrega,
        @Min(1) @Max(5) Integer avaliacaoCliente,
        @Min(1) @Max(5) Integer avaliacaoEntregador
) {}
