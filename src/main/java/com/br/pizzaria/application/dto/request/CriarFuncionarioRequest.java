package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO de entrada: criar Funcionario
 * CPF é informado (PK natural)
 */
public record CriarFuncionarioRequest(
        @NotBlank @Size(min = 11, max = 11) String cpfFuncionario,
        @NotBlank String nome,
        @NotBlank String cargo,
        @NotNull @DecimalMin("0.01") BigDecimal salario,
        @NotNull LocalDate dataContratacao
) {}
