package com.br.pizzaria.domain.repository;

import com.br.pizzaria.domain.entity.Estoque;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository {
    Estoque salvar(Estoque estoque);
    Optional<Estoque> buscarPorId(Long idMovimento);
    List<Estoque> listarPorProduto(Long idProduto);
    List<Estoque> listarTodos();
    List<Estoque> listarPorTipoMovimento(String tipoMovimento);
}
