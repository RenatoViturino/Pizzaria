package com.br.pizzaria.application.dto.response;

public record EntregaResponse(
        Long idEntrega,
        String cpfFuncionario,
        Long idPedido,
        String statusEntrega,
        Integer avaliacaoCliente,
        Integer avaliacaoEntregador
) {}
