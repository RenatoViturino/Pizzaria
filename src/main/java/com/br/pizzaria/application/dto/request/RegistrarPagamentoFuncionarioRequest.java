package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RegistrarPagamentoFuncionarioRequest(
        @NotBlank @Size(min = 11, max = 11) String cpfFuncionario,
        @NotNull @Positive BigDecimal valor,
        @NotNull LocalDate dataPagamento
) {}
