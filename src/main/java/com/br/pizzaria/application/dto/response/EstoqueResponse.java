package com.br.pizzaria.application.dto.response;

import java.time.LocalDateTime;

/**
 * DTO de resposta: Estoque (movimentação)
 */
public record EstoqueResponse(
        Long idMovimento,
        String tipoMovimento,
        Integer quantidade,
        LocalDateTime dataHora,
        Long idProduto,
        String nomeProduto
) {}
