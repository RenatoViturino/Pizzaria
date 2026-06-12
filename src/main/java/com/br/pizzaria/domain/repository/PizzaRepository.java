package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Produto;
import java.util.List;
import java.util.Optional;

/**
 * Porta de saída: repositório de Produto/Pizza (PK: Long idProduto)
 * Renomeado para alinhar com o diagrama — entidade é Produto.
 */
public interface PizzaRepository {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(Long id);
    List<Produto> listarTodos();
    void deletar(Long id);
}
