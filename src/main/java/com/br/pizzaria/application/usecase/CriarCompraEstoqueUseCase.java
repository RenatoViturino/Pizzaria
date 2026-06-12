package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.CriarCompraEstoqueRequest;
import com.br.pizzaria.domain.entity.CompraEstoque;

public interface CriarCompraEstoqueUseCase {
    CompraEstoque criar(CriarCompraEstoqueRequest request);
}
