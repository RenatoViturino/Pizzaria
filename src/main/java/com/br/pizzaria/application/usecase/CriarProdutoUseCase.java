package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.CriarProdutoRequest;
import com.br.pizzaria.application.dto.response.ProdutoResponse;

public interface CriarProdutoUseCase {
    ProdutoResponse executar(CriarProdutoRequest request);
}
