package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CompraEstoqueResponse(
        Long idCompra,
        String fornecedor,
        LocalDate dataCompra,
        BigDecimal valorTotal
) {}
