package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FuncionarioResponse(
        String cpfFuncionario,
        String nome,
        String cargo,
        BigDecimal salario,
        LocalDate dataContratacao
) {}
