package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.response.ProdutoResponse;

import java.util.List;

public interface BuscarProdutoUseCase {
    ProdutoResponse buscarPorId(Long idProduto);
    List<ProdutoResponse> listarTodos();
    List<ProdutoResponse> listarPorTipo(String tipo);
}
