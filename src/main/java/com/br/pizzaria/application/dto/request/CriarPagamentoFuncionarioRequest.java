package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO de entrada: registrar pagamento de funcionário
 */
public record CriarPagamentoFuncionarioRequest(
        @NotBlank @Size(min = 11, max = 11) String cpfFuncionario,
        @NotNull @DecimalMin("0.01") BigDecimal valor,
        @NotNull LocalDate dataPagamento
) {}
