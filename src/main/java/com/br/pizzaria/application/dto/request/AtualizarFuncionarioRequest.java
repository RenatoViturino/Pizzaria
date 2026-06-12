package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

/**
 * DTO de entrada: atualizar Funcionário (campos opcionais)
 */
public record AtualizarFuncionarioRequest(
        String nome,
        String cargo,
        @DecimalMin("0.01") BigDecimal salario
) {}
