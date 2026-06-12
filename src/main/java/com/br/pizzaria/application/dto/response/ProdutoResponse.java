package com.br.pizzaria.application.dto.response;

import java.math.BigDecimal;

public record ProdutoResponse(
        Long idProduto,
        String nome,
        String tipo,
        BigDecimal preco,
        Integer estoqueAtual
) {}
