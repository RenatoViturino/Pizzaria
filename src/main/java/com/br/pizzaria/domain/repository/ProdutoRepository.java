package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Produto;

import java.util.List;
import java.util.Optional;

/**
 * Porta de saída (interface do domínio): ProdutoRepository
 */
public interface ProdutoRepository {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(Long idProduto);
    List<Produto> listarTodos();
    List<Produto> listarPorTipo(String tipo);
    void deletar(Long idProduto);
    boolean existePorId(Long idProduto);
}
