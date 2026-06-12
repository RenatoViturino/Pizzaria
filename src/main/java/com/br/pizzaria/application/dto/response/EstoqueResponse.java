package com.br.pizzaria.application.dto.response;

import java.time.LocalDateTime;

public record EstoqueResponse(
        Long idMovimento,
        Long idProduto,
        String tipoMovimento,
        Integer quantidade,
        LocalDateTime dataHora
) {}
