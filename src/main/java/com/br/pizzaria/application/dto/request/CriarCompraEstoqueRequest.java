package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarCompraEstoqueRequest(
        @NotBlank String fornecedor,
        @NotNull LocalDate dataCompra,
        @NotNull @Positive BigDecimal valorTotal
) {}
