package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.AtualizarProdutoRequest;
import com.br.pizzaria.application.dto.response.ProdutoResponse;

public interface AtualizarProdutoUseCase {
    ProdutoResponse executar(Long idProduto, AtualizarProdutoRequest request);
}
