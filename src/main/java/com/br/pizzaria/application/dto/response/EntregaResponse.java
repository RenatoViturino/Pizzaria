package com.br.pizzaria.application.dto.response;

/**
 * DTO de resposta: Entrega
 * PK: idEntrega (Long) — conforme diagrama
 */
public record EntregaResponse(
        Long idEntrega,
        String statusEntrega,
        Integer avaliacaoCliente,
        Integer avaliacaoEntregador,
        String cpfFuncionario,
        String nomeFuncionario
) {}
