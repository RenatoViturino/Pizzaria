package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO de resposta: PagamentoFuncionario
 * PK: idPagamento (Long) — conforme diagrama
 */
public record PagamentoFuncionarioResponse(
        Long idPagamento,
        BigDecimal valor,
        LocalDate dataPagamento,
        String cpfFuncionario
) {}
