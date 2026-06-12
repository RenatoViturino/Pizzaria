package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record AtualizarFuncionarioRequest(
        String nome,
        String cargo,
        @Positive BigDecimal salario
) {}
