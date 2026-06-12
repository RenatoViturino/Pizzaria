package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO de resposta: Funcionario
 * PK: cpfFuncionario (String) — conforme diagrama
 */
public record FuncionarioResponse(
        String cpfFuncionario,
        String nome,
        String cargo,
        BigDecimal salario,
        LocalDate dataContratacao
) {}
