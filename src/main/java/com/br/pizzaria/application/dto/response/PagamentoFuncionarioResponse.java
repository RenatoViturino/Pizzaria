package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PagamentoFuncionarioResponse(
        Long idPagamento,
        String cpfFuncionario,
        BigDecimal valor,
        LocalDate dataPagamento
) {}
