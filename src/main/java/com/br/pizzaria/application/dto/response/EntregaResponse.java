package com.br.pizzaria.application.dto.response;

/**
 * DTO de resposta: Entrega
 */
public record EntregaResponse(
        Long idEntrega,
        String statusEntrega,
        Integer avaliacaoCliente,
        Integer avaliacaoEntregador,
        String cpfFuncionario,
        String nomeFuncionario,
        Long idPedido
) {}
